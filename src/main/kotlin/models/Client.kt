package models

import javafx.collections.ObservableList
import tornadofx.*

class Client(number: Int, firstName: String, lastName: String, id: String, accounts: ObservableList<Account>) {

    var number by property<Int>(number)
    fun numberProperty() = getProperty(Client :: number)

    var firstName by property<String>(firstName)
    fun firstNameProperty() = getProperty(Client :: firstName)

    var lastName by property<String>(lastName)
    fun lastNameProperty() = getProperty(Client :: lastName)

    var id by property<String>(id)
    fun idProperty() = getProperty(Client :: id)

    var accounts by property<ObservableList<Account>>(accounts)
    fun accountProperty() = getProperty(Client :: accounts)
}

class ClientModel : ItemViewModel<Client>() {
    val firstName = bind { item?.firstNameProperty() }
    val lastName = bind { item?.lastNameProperty() }
    val id = bind { item?.idProperty() }
    val accounts= bind { item?.accountProperty()}
}