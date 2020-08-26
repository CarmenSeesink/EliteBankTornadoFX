import javafx.beans.property.*
import javafx.collections.ObservableList
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

// Client Class
class Client(title: String, firstName: String, lastName: String, id: String, accounts: ObservableList<Account>, img: String){
    var accounts = SimpleListProperty<SimpleObjectProperty<Account>>()
    val titleProperty = SimpleStringProperty(title)
    val firstNameProperty = SimpleStringProperty(firstName)
    val lastNameProperty = SimpleStringProperty(lastName)
    val idProperty = SimpleStringProperty(id)
    val imgProperty = SimpleStringProperty(img)
    var amount = SimpleFloatProperty(0f)
    var active = SimpleBooleanProperty(true)
}

// Client View Model
class ClientViewModel(val client: Client): ViewModel(){
    val title = bind { client.titleProperty }
    val firstName = bind { client.firstNameProperty }
    val lastName = bind { client.lastNameProperty }
    val id = bind { client.idProperty }
    val img = bind { client.imgProperty }
    val amount = bind { client.amount }
    val active = bind { client.active }
    val accounts = bind { client.accounts }

 //Search Function
// fun searchClient(input: String): Client {
//     for(client in clients) {
//         if (input == firstName.value || input == id.value) {
//             return client
//         }
//         else {
//             println("No Clients")
//         }
//     }
// }
}

// Client View
class ClientView: View("Elite Bank") {
    val client: ClientViewModel by inject()
    val clientList = mutableListOf(
        Client("MRS","Mary", "Johnson", "64304789801", observableListOf(Account("Mary", "Gold Cheque", 2000f, 30)), "1.png")
    ).asObservable()

    val accountList = mutableListOf(
        Account("893047890", "Gold Cheque", 15000.0f, 1),
        Account("893047890", "Tax Free Savings", 35000.0f, 1),
        Account("893047890", "Diamond Cheque", 30000.0f, 2)
    )
    val firstName = SimpleStringProperty()

    override val root = scrollpane {
        borderpane {
            style {
                backgroundColor += Color.WHITESMOKE
            }
            setPrefSize(1440.0, 960.0)
            paddingAll = 40.0
            top = hbox {
                spacing = 1140.0
                label("ELITE BANK") {
                    useMaxWidth = true
                    style {
                        fontWeight = FontWeight.EXTRA_BOLD
                        fontSize = 12.px
                        fontFamily = "Avenir"
                    }
                }
                button("← Back") {
                    paddingAll = 10.0
                    paddingLeft = 30.0
                    paddingRight = 30.0
                    action {
                        replaceWith<MainBank>()
                    }
                    style {
                        fontWeight = FontWeight.NORMAL
                        textFill = Color.BLACK
                        fontSize = 12.px
                        borderWidth += box(1.5.px)
                        fontFamily = "Avenir"
                        backgroundRadius += box(8.px)
                        borderColor += box(Color.BLACK)
                        borderRadius += box(8.px)
                        backgroundColor = multi(Color.WHITE, Color.WHITE, Color.WHITE)
                    }
                }
            }
                left = vbox {
                    paddingAll = 25.0
                    label("CLIENT DETAILS") {
                        useMaxWidth = true
                        style {
                            fontWeight = FontWeight.EXTRA_BOLD
                            fontSize = 16.px
                            textFill = Color.LIGHTGRAY
                            fontFamily = "Avenir"
                        }
                        vboxConstraints {
                            marginTop = 20.0
                            marginBottom = 20.0
                        }
                    }
                    for (client in clientList) {
                        add(AccountHolderView(ClientViewModel(client)))
                    }
                    vbox {
                        spacing = 30.0
                        for (account in accountList) {
                            add(AccountView(AccountViewModel(account)))
                        }
                    }
                }
            }
        }
    }


