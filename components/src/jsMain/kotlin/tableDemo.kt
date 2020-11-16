import dev.fritz2.binding.RootStore
import dev.fritz2.components.*
import dev.fritz2.components.model.*
import dev.fritz2.dom.html.Div
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.identification.uniqueId
import dev.fritz2.lenses.Lens
import dev.fritz2.lenses.buildLens
import dev.fritz2.lenses.format
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.map

val defaultList = listOf(
    Person(uniqueId(),
        1,
        "Mr. John Doe",
        "Street",
        "1",
        "13245",
        "City",
        Address("Street")
    ),
    Person(uniqueId(), 2, "Mrs. Jane Doe", "Avenue", "42", "78945", "Hometown"),
    Person(uniqueId(), 3, "Dr.  Jean Dupont", "Rue de bleu", "13", "56473", "Ville"),
    Person(uniqueId(), 4, "Sir  Juan Pérez", "El Camino", "75", "85236", "Ciudad")
)


val _idLense = buildLens("_id", Person::_id) { p, v -> p.copy(_id = v) }
val personIdLense = buildLens("id", Person::id) { p, v -> p.copy(id = v) }
val fullNameLense = buildLens("fullName", Person::fullName) { p, v -> p.copy(fullName = v) }
val personAddressLens = buildLens("address", Person::address) { p, v -> p.copy(address = v) }
val streetLense = buildLens("street", Address::street) { p, v -> p.copy(street = v) }
/*
val houseNumberLense = buildLens("houseNumber", Person::houseNumber) { p, v -> p.copy(houseNumber = v) }
val postalCodeLense = buildLens("postalCode", Person::postalCode) { p, v -> p.copy(postalCode = v) }
val cityLense = buildLens("city", Person::city) { p, v -> p.copy(city = v) }
*/

object TableStore : RootStore<List<Person>>(defaultList, "personData") {


    val remove = handle<Person> {
            list, toDelete ->
        list.filter { it != toDelete }
    }
}

object Formats {
    val intFormat: Lens<Int, String> = format(
        parse = { it.toInt() },
        format = { it.toString() }
    )
}


@ExperimentalCoroutinesApi
fun RenderContext.tableDemo(): Div {

    return div {
        flexBox({
            direction { column }
            padding { normal }
        }) {
            h1 { +"Table Showcase" }

            val selectedStore = object: RootStore<List<Person>>(emptyList()){

                val add = handle<Person> { list, selected ->
                    if( !list.contains(selected) ) {
                        list + selected
                    }  else {
                        list
                    }
                }

                val toggle = handle<Person> { list, item ->
                    console.info(item)
                    if( !list.contains(item) ) {
                        list + item
                    }  else {
                        list.filter { it != item }
                    }
                }

                val clearList = handle {
                    emptyList()
                }

            }

            p{
                selectedStore.data.map {
                    "Aktuell sind " + it.count() + " Zeilen ausgewählt!"
                }
            }

            h2{+"myTable"}
            table<Person,Int>( rowIdProvider = Person::id ) {
                selectionMode(TableComponent.Companion.SelectionMode.MULTI)
                configStore(listOf(
                    TableComponent.TableColumn(
                        personIdLense + Formats.intFormat,
                        "ID"
                    ),
                    TableComponent.TableColumn(
                        fullNameLense,
                        "Name"
                    ),
                    TableComponent.TableColumn(
                        personAddressLens + streetLense,
                        "editable Street",
                        content = { ctx,store,_ ->
                            ctx.apply{
                                inputField(store = store) {  }
                            }
                        }
                    ),
                    TableComponent.TableColumn(
                        personAddressLens + streetLense,
                        "Street"
                    ),
                    TableComponent.TableColumn(
                        null,
                        "Actions",
                        content = {ctx, col, row ->
                            ctx.apply {
                                clickButton {
                                    text("clear list of selected")
                                } handledBy selectedStore.clearList
                            }
                        }
                    )


                ))
                tableStore(TableStore)
                selectedRows(selectedStore.data)

                selectedAllRowEvents = selectedStore.update
                selectedRowEvent = selectedStore.toggle

            }
         }
    }
}
