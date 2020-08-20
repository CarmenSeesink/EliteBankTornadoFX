package client

import account.Account
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import tornadofx.*

// Client Class
class Client(firstName: String, lastName: String, id: String){
    var accounts = SimpleObjectProperty(ClientAccountsViewModel(ClientAccounts()))
    val firstNameProperty = SimpleStringProperty(firstName)
    val lastNameProperty = SimpleStringProperty(lastName)
    val idProperty = SimpleStringProperty(id)
    var amount = SimpleFloatProperty(0f)
    var active = SimpleBooleanProperty(true)
}

// Client View Model
class ClientViewModel(val client: Client): ViewModel(){
    val firstName = bind { client.firstNameProperty }
    val lastName = bind { client.lastNameProperty }
    val id = bind { client.idProperty }
    val amount = bind { client.amount }
    val active = bind { client.active }
    val accounts = bind { client.accounts }

//    fun addAccount(account: Account){
//      client.accounts.value.addAccount(account)
//    }
//
//    fun searchBy(firstName: String){
//
//    }
}

// Client View
class ClientView(val model: ClientViewModel): View(){

    override val root = vbox {
        spacing = 10.0
        prefWidth = 400.0
        style {
            textAlignment = TextAlignment.CENTER
        }
        label(model.firstName.value) {
            textFill = Color.BLACK

            vboxConstraints {
                alignment = Pos.CENTER
            }
            style{
                fontSize = 20.px
            }
        }

        add(ClientAccountsView(model.accounts.value).root)

    }
}

// Client Editor
class ClientEditor: View("Client Details") {
    val client: ClientViewModel by inject()

    override val root = form {
        fieldset(title) {
            field("First Name") {
                textfield(client.firstName).required()
            }
            field("Last Name") {
                textfield(client.lastName).required()
            }
            field("ID Number") {
                textfield(client.id).required()
            }
        }
    }
}