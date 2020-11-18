package dev.fritz2.components

import dev.fritz2.binding.*
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.dom.html.Td
import dev.fritz2.dom.html.Th
import dev.fritz2.dom.html.render
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


class NaiveSorter<T> {
    fun sortedBy(elements: List<T>, config: List<TableComponent.TableColumn<T>>): List<T> {
        val filterRules = config.filter {
            it.sortDirection != TableComponent.Companion.SortDirection.UNSORTABLE
                    && it.sortDirection != TableComponent.Companion.SortDirection.NONE
                    // TODO: Not right!
                    // TODO: && no special sorting given
                    && it.lens != null
        }
        return if (filterRules.isNotEmpty()) {
            val first = filterRules.first()
            elements.sortedWith(
                filterRules
                    .drop(1)
                    .fold(
                        when (first.sortDirection) {
                            TableComponent.Companion.SortDirection.ASC -> {
                                compareBy { first.lens!!.get(it) }
                            }
                            else -> {
                                compareByDescending { first.lens!!.get(it) }
                            }
                        },
                        { a, b ->
                            when (b.sortDirection) {
                                TableComponent.Companion.SortDirection.ASC -> {
                                    a.thenBy { b.lens!!.get(it) }
                                }
                                else -> {
                                    a.thenByDescending { b.lens!!.get(it) }
                                }
                            }
                        }
                    )
            )
        } else elements
    }
}

/**
 * TODO open questions
 *  tfoot what will we do with this section of a table?
 *
 * TODO open todos
 *
 */
class TableComponent<T> {
    companion object {
        const val prefix = "table"
        val staticCss = staticStyle(
            prefix,
            """
                display:grid;
                //min-width: 100vw;
                width: auto;
                flex: 1;
                display: grid;
                border-collapse: collapse;
                text-align: left;
                
                thead,tbody,tr {
                    display:contents;
                }
                             
                thead {             
                  grid-area:main;  
                }
                
                tbody {             
                  grid-area:main;  
                }
                                
                th,
                td {
                  padding: 0.5rem;
                  overflow: hidden;
                  text-overflow: ellipsis;
                  white-space: nowrap;
                  &:last-child {
                    border-right: none;
                  }
                }
                
                td {
                    border-bottom: 1px solid inherit;
                }
                
                th {
                  position: sticky;
                  top: 0;
                  background: rgb(52, 58, 64);
                  text-align: left;
                  font-weight: normal;
                  font-size: 1.1rem;
                  color: rgb(226, 232, 240);
                  position: relative;
                }
                
                tr {
                    td { background: rgba(52, 58, 64, 0.1); }
                    &:nth-child(even) {
                        td {  background: rgba(52, 58, 64, 0.2); }
                    } 
                    &.selected {
                    td { background: rgba(255, 193, 7, 0.8) }
                    }
                }
            """
        )

        enum class SelectionMode {
            NONE,
            SINGLE,
            SINGLE_CHECKBOX,
            MULTI
        }

        enum class SortDirection {
            UNSORTABLE,
            NONE,
            ASC,
            DESC
        }

        enum class CaptionPlacement {
            TOP,
            BOTTOM
        }

    }


    data class TableColumn<T>(
        val lens: Lens<T, String>? = null,
        val headerName: String = "",
        val minWidth: Property? = null,
        val maxWidth: Property? = null,
        val displayPriority: String = "sm",
        val hidden: Boolean = false,
        val position: Int = 0,
        val sortDirection: SortDirection = SortDirection.NONE,
        val filter: Unit = Unit,
        val styling: Style<BasicParams> = {},
        val stylingHead: Style<BasicParams> = {},
        val contentHead: (renderContext: Th, tableColumn: TableColumn<T>) -> Unit = { renderContext, config ->
            renderContext.apply { +config.headerName }
        },
        val content: (
            renderContext: Td,
            cellStore: Store<String>?,
            rowStore: SubStore<List<T>, List<T>, T>?
        ) -> Unit = { renderContext, store, _ ->
            renderContext.apply {
                store?.data?.asText()
            }
        }
    )

    var sorter: NaiveSorter<T>? = null

    var defaultMinWidth: Property = "150px"
    var defaultMaxWidth: Property = "1fr"

    var selectionMode: Flow<SelectionMode> = flowOf(SelectionMode.NONE)
    fun selectionMode(value: SelectionMode) {
        selectionMode = flowOf(value)
    }

    fun selectionMode(value: Flow<SelectionMode>) {
        selectionMode = value
    }

    var configStore: Store<List<TableColumn<T>>> = storeOf(emptyList())
    fun configStore(value: Store<List<TableColumn<T>>>) {
        configStore = value
    }

    fun configStore(value: List<TableColumn<T>>) {
        configStore.update(value)
    }

    var tableStore: RootStore<List<T>> = storeOf(emptyList())
    fun tableStore(value: RootStore<List<T>>) {
        tableStore = value
    }

    var selectedRows: Flow<List<T>> = flowOf(emptyList())
    fun selectedRows(value: Flow<List<T>>) {
        selectedRows = value
    }

    var selectedRowEvent: SimpleHandler<T>? = null
    var selectedAllRowEvents: SimpleHandler<List<T>>? = null


    var captionPlacement: CaptionPlacement = CaptionPlacement.TOP
    fun captionPlacement(value: CaptionPlacement) {
        captionPlacement = value
    }

    var caption: (RenderContext.() -> Unit)? = null
    fun caption(value: (RenderContext.() -> Unit)) {
        caption = {
            (::caption.styled() {
                if (captionPlacement == CaptionPlacement.TOP) {
                    css("grid-area:header;")
                } else {
                    css("grid-area:footer;")
                }
            }){ value() }
        }
    }

    fun caption(value: String) {
        this.caption(flowOf(value))
    }

    fun caption(value: Flow<String>) {
        caption = {
            (::caption.styled() {
                if (captionPlacement == CaptionPlacement.TOP) {
                    css("grid-area:header;")
                } else {
                    css("grid-area:footer;")
                }
            }){ value.asText() }
        }
    }
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

    val tableBaseClass = if (baseClass != null) {
        baseClass + TableComponent.staticCss
    } else {
        TableComponent.staticCss
    }
    component.selectionMode.watch()


    val additionalCol = component.selectionMode.map { selectionMode ->
        if (selectionMode == TableComponent.Companion.SelectionMode.MULTI) {
            listOf(
                TableComponent.TableColumn<T>(
                    minWidth = "50px",
                    maxWidth = "50px",
                    contentHead = { ctx, _ ->
                        ctx.apply {
                            checkbox({ display { inlineBlock } }, id = uniqueId()) {
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
                        }
                    },
                    content = { ctx, _, rowStore ->
                        ctx.apply {
                            checkbox(
                                { display { inlineBlock } },
                                id = uniqueId()
                            ) {
                                text("")
                                checkedBackgroundColor { theme().colors.warning }
                                if (rowStore != null) {
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
                        }
                    }
                )
            )
        } else if (selectionMode == TableComponent.Companion.SelectionMode.SINGLE_CHECKBOX) {
            listOf(TableComponent.TableColumn<T>(
                minWidth = "50px",
                maxWidth = "50px",
                content = { ctx, _, rowStore ->
                    ctx.apply {
                        checkbox(
                            { display { inlineBlock } },
                            id = uniqueId()
                        ) {
                            text("")
                            checkedBackgroundColor { theme().colors.warning }
                            if (rowStore != null) {
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
                    }
                }
            ))
        } else {
            emptyList()
        }
    }
    val config = additionalCol.combine(component.configStore.data.map {
        it.filterNot { it.hidden }.sortedBy { it.position }
    }) { a, b -> a + b }

    val gridCols = config.map { configItems ->
        var minmax = ""
        var header = ""
        var footer = ""
        var main = ""


        configItems.forEach { item ->
            val min = item.minWidth ?: component.defaultMinWidth
            val max = item.maxWidth ?: component.defaultMaxWidth

            minmax += "minmax($min, $max)"
            main += "main "
            footer += "footer "
            header += "header "
        }

        """
            grid-template-columns: $minmax;                
            grid-template-rows: auto;
            grid-template-areas:
           "$header"
           "$main"
           "$footer";
           """
    }

    (::table.styled({
        styling()
    }, tableBaseClass, id, prefix) {}){
        attr("style", gridCols)
        if (component.captionPlacement == TableComponent.Companion.CaptionPlacement.TOP) {
            component.caption?.invoke(this)
        }

        thead {
            tr {
                config.renderEach { ctx ->
                    (::th.styled(ctx.stylingHead) {})  {
                        ctx.contentHead(this, ctx)
                    }
                }
            }
        }
        tbody {
            component.tableStore.data.combine(config) { tableData, config ->
                if (component.sorter == null) {
                    tableData
                } else {
                    component.sorter!!.sortedBy(tableData, config)
                }
            }.renderEach(rowIdProvider) { t ->
                val rowStore = component.tableStore.sub(t, rowIdProvider)
                val selected = component.selectedRows.combine(rowStore.data) { selectedRows, thisRow ->
                    selectedRows.contains(thisRow)
                }


                tr {
                    className(selected.combine(component.selectionMode) { selected, selectionMode ->
                        if (selected && selectionMode == TableComponent.Companion.SelectionMode.SINGLE) {
                            "selected"
                        } else {
                            ""
                        }
                    })
                    component.selectionMode.render { selectionMode ->
                        if (selectionMode == TableComponent.Companion.SelectionMode.SINGLE) {
                            component.selectedRowEvent?.let {
                                clicks.events.combine(rowStore.data) { _, thisRow ->
                                    thisRow
                                } handledBy it
                            }
                        }
                    }

                    config.renderEach { ctx ->
                        (::td.styled(ctx.styling) {}) {
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

            if (component.captionPlacement == TableComponent.Companion.CaptionPlacement.BOTTOM) {
                component.caption?.invoke(this)
            }

        }
    }
}
