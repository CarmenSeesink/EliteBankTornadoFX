import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

// Account Container
class AccountDetailView: View("Client Details") {
    val accountList = mutableListOf(
        Account("Billy", "Tax Free Savings", 12.0f, 1),
        Account("Jane", "Gold Cheque", 24.0f, 1),
        Account("Jane", "Diamond Cheque", 24.0f, 2),
    )

    override val root = hbox {
        for (acc in accountList) {
            add(AccountView(AccountViewModel(acc)))
            button("Next") {
                action {
                    replaceWith<MainBank>()
                }
            }
        }
    }
}