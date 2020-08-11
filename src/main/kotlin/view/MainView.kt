package view

import javafx.collections.ObservableList
import tornadofx.*

class MainView: View("EliteBank") {
    override val root = hbox {
        this += ClientList::class
        this += ClientEditor::class
    }
}
//    var showText = true
//
//    override val root = tableview(clients) {
//        readonlyColumn("ID", Client::id)
//        readonlyColumn("Name", Client::name)
//        readonlyColumn("Country", Client::country)
//        rowExpander(expandOnDoubleClick = true) {
//            paddingLeft = expanderColumn.width
//            tableview(it.branches) {
//                readonlyColumn("ID", Account::id)
//                readonlyColumn("Type", Account::facilityCode)
//                readonlyColumn("Number", Account::city)
//                readonlyColumn("Balance", Account::stateProvince)
//            }
//        }
//    }
//}
//
//class Client(val id: Int, val name: String, val country: String, val branches: ObservableList<Account>)
//
//class Account(val id: Int, val facilityCode: String, val city: String, val stateProvince: String)
//
//val clients = listOf(
//    Client(
//        1, "Pacific Northwest", "USA", listOf(
//            Account(1, "D", "Seattle", "WA"),
//            Account(2, "W", "Portland", "OR")
//        ).asObservable()
//    ),
//    Client(
//        2, "Alberta", "Canada", listOf(
//            Account(3, "W", "Calgary", "AB")
//        ).asObservable()
//    ),
//    Client(
//        3, "Midwest", "USA", listOf(
//            Account(4, "D", "Chicago", "IL"),
//            Account(5, "D", "Frankfort", "KY"),
//            Account(6, "W", "Indianapolis", "IN")
//        ).asObservable()
//    )
//).asObservable()