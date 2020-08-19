package view

import controller.ClientController
import models.Client
import models.ClientModel
import javafx.stage.Stage
import models.Account
import tornadofx.*

class ClientList : View() {
    val ctrl: ClientController by inject()
    val model : ClientModel by inject()

    override val root = tableview(ctrl.clients) {
        isEditable = true
        column("First Name", Client::firstNameProperty).makeEditable()
        column("Last Name", Client::lastNameProperty).makeEditable()
        column("ID Number", Client::idProperty).makeEditable()
        columnResizePolicy = SmartResize.POLICY
        bindSelected(model)

        rowExpander {
            paddingLeft = expanderColumn.width
            tableview(it.accounts) {
                readonlyColumn("Client", Account::holderId)
                readonlyColumn("Type",Account::type)
                readonlyColumn("Balance",Account::balance)
            }
        }
    }
}