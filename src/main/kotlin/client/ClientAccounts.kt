package client

import account.Account
import account.AccountView
import account.AccountViewModel
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import tornadofx.*


class ClientAccounts {
    val accountProperty = SimpleListProperty<SimpleObjectProperty<Account>>()
    private var accountValue = 0
}

class ClientAccountsViewModel(val clientAccounts: ClientAccounts): ViewModel(){
    val accounts = bind { clientAccounts.accountProperty }

    fun addAccount(account: Account){
        accounts.value.add(SimpleObjectProperty(account))
    }

//    fun deposit(account: Account){
//        accounts.value.add(SimpleObjectProperty(account))
//    }
}

class ClientAccountsView(val viewModel: ClientAccountsViewModel): View() {

    override val root = hbox {
        flowpane {
            hgap = 10.0
            vgap = 10.0
            children.bind(viewModel.accounts.value) {
                AccountView(AccountViewModel(it.get())).root
            }
        }
    }
}