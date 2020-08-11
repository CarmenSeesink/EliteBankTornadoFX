package models

import tornadofx.ItemViewModel
import tornadofx.getProperty
import tornadofx.property

class Client(firstName: String, lastName: String, id: String) {
    var firstName by property<String>(firstName)
    fun firstNameProperty() = getProperty(Client :: firstName)

    var lastName by property<String>(lastName)
    fun lastNameProperty() = getProperty(Client :: lastName)

    var id by property<String>(id)
    fun idProperty() = getProperty(Client :: id)
}

class ClientModel : ItemViewModel<Client>() {
    val firstName = bind { item?.firstNameProperty() }
    val lastName = bind { item?.lastNameProperty() }
    val id = bind { item?.idProperty() }
}