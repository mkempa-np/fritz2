package dev.fritz2.components

import dev.fritz2.binding.*
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.dom.html.Td
import dev.fritz2.dom.states
import dev.fritz2.identification.uniqueId
import dev.fritz2.lenses.Lens
import dev.fritz2.styling.StyleClass
import dev.fritz2.styling.params.BasicParams
import dev.fritz2.styling.params.GridParams
import dev.fritz2.styling.params.Style
import dev.fritz2.styling.staticStyle
import dev.fritz2.styling.theme.Property
import dev.fritz2.styling.theme.theme
import kotlinx.coroutines.flow.*


class TableComponent <T>{
    companion object {
        const val prefix = "table"
        val staticCss = staticStyle(
            prefix,
            """
                text-align: left;
            """
        )

        enum class SelectionMode {
            NONE,
            SINGLE,
            MULTI
        }

        enum class SortDirection {
            NONE,
            ASC,
            DESC
        }
    }

    data class TableColumn<T>(
        val lens: Lens<T,String>? = null,
        val headerName: String,
        val minWidth: Property? = null,
        val maxWidth: Property? = null,
        val displayPriority: String = "sm",
        val hidden: Boolean = false,
        val position: Int = 0,
        val sortDirection: SortDirection = SortDirection.NONE,
        val filter: Unit = Unit,
        val styling: Style<BasicParams> = {},
        val content: (renderContext: Td,
                      cellStore: Store<String>?,
                      rowStore: SubStore<List<T>,List<T>,T>?) -> Unit  = { renderContext,store,_ ->
                        renderContext.apply {
                            store?.data?.asText()
                        }
                      }
    )

    var selectionMode: SelectionMode = SelectionMode.NONE
    fun selectionMode(value: SelectionMode) {
        selectionMode = value
    }

    var configStore: Store<List<TableColumn<T>>> = storeOf(emptyList())
    fun configStore(value: Store<List<TableColumn<T>>>) {
       configStore = value
    }
    fun configStore(value: List<TableColumn<T>>) {
        configStore.update(value)
    }

    //TODO - Store? Aktuell nicht möglich, wegen des benötigten ID Provider
    var tableStore: RootStore<List<T>> = storeOf(emptyList())
    fun tableStore(value: RootStore<List<T>>) {
        tableStore = value
    }

    var selectedRows: Flow<List<T>> = flowOf(emptyList())
    fun selectedRows(value: Flow<List<T>>) {
        selectedRows = value
    }

    var selectedRowEvent: SimpleHandler<T>? = null
    var selectedAllRowEvents:  SimpleHandler<List<T>>? = null
}

fun <T, I> RenderContext.table(
    styling: GridParams.() -> Unit = {},
    baseClass: StyleClass? = null,
    id: String? = null,
    prefix: String = TableComponent.prefix,
    rowIdProvider: (T) -> I,
    build: TableComponent<T>.() -> Unit = {}
) {
    val component = TableComponent<T>().apply(build)

    val config = component.configStore.data.map { it.sortedBy { it.position } }


    (::table.styled({
        styling()
    },TableComponent.staticCss,id,prefix){}){
        className(component.configStore.data.map {
            staticStyle(
                "myTable", {
                    css("display:grid;")
                    columns { repeat(it.size){ "1fr" } }
                }
            ).name
        })

        thead {
            tr {
                th {
                    if (component.selectionMode == TableComponent.Companion.SelectionMode.MULTI) {
                        checkbox( {display { inlineBlock }  }  ,id = uniqueId()) {
                            text("")
                            borderColor { theme().colors.secondary }
                            checkedBackgroundColor { theme().colors.warning }
                            events {
                                component.selectedAllRowEvents?.let {
                                    changes.states().combine(component.tableStore.data) { selected, list ->
                                        if (selected) {
                                            list
                                        } else {
                                            emptyList()
                                        }
                                    } handledBy it
                                }
                            }
                        }
                    } else {
                        span{}
                    }
                }

                config.renderEach { ctx ->
                    th {
                        +ctx.headerName
                    }
                }
            }
        }
        tbody {
            component.tableStore.renderEach(rowIdProvider){ rowStore ->
                tr {
                    if ( component.selectionMode == TableComponent.Companion.SelectionMode.MULTI)  {
                        td {
                            checkbox({ display { inlineBlock }  },
                                id = uniqueId()) {
                                text("")
                                checkedBackgroundColor { theme().colors.warning }
                                checked {
                                    component.selectedRows.combine(rowStore.data) { selectedRows, thisRow ->
                                        selectedRows.contains(thisRow)
                                    }
                                }
                                events {
                                    component.selectedRowEvent?.let {
                                        clicks.events.combine(rowStore.data) { _, thisRow ->
                                            thisRow
                                        } handledBy it
                                    }

                                }
                            }
                        }
                    } else if( component.selectionMode == TableComponent.Companion.SelectionMode.SINGLE ) {
                        component.selectedRowEvent?.let {
                            clicks.events.combine(rowStore.data) { _, thisRow ->
                                thisRow
                            } handledBy it
                        }
                    }
                    config.renderEach { ctx ->
                        td {
                            if (ctx.lens != null) {
                                val b = rowStore.sub(ctx.lens)
                                ctx.content(this, b, rowStore)
                            } else {
                                ctx.content(this, null, rowStore)
                            }
                        }
                    }
                }
            }
        }
    }
}
