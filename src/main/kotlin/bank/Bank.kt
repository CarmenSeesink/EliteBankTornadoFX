package bank

import account.Account
import client.Client
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import tornadofx.Controller
import tornadofx.ViewModel
import tornadofx.shuffle

class Bank (name: String = "Elite Bank") {
    val accountsProperty = SimpleListProperty<SimpleObjectProperty<Account>>()
    var closeOffProperty = SimpleBooleanProperty(true)
    var clientsProperty = SimpleListProperty<SimpleObjectProperty<Client>>()
}

class BankViewModel(val bank: Bank): ViewModel(){
    var closeOff = bind { bank.closeOffProperty }
    var clients = bind { bank.clientsProperty }
    var account = bind { bank.accountsProperty }

    init {
        val accountList = mutableListOf<SimpleObjectProperty<Account>>()
    }

    fun closeOffMonth(){
        closeOff.value = !closeOff.value
    }

    fun addClient(client: Client){
        clients.value.add(SimpleObjectProperty(client))
    }

}