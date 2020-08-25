import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class MainBank: View("ELITE BANK") {

val clientList = mutableListOf(
        Client("MRS", "Mary", "Johnson", "6406125128051", observableListOf(Account("Mary", "Gold Cheque", 2000f, 30)), "1.png"),
        Client("MR", "Mike", "Williams", "7209234157030", observableListOf(Account("Eric", "Gold Cheque", 2000f, 30)), "2.png"),
        Client("MS", "Jane", "Andrews", "7911050074059", observableListOf(Account("Jane", "Gold Cheque", 2000f, 30)), "3.png"),
        Client("MR", "Henry", "Fischer", "6804316177781", observableListOf(Account("Henry", "Gold Cheque", 2000f, 30)), "4.png")).asObservable()

    val clientTitle = SimpleStringProperty()
    val firstName = SimpleStringProperty()
    val lastName = SimpleStringProperty()
    val idNumber = SimpleStringProperty()
    val img = SimpleStringProperty()

    override val root = scrollpane {
            borderpane {
                style {
                    backgroundColor += Color.WHITESMOKE
                }
                setPrefSize(1440.0, 960.0)
                paddingAll = 40.0
                top = label("ELITE BANK") {
                    useMaxWidth = true
                    style {
                        fontWeight = FontWeight.EXTRA_BOLD
                        fontSize = 12.px
                        fontFamily = "Avenir"
                    }
                }
                left = vbox {
                    paddingAll = 25.0
                    label("OUR CLIENTS") {
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
                    vbox {
                        spacing = 10.0
                        for (client in clientList) {
                            hbox {
                                spacing = 20.0
                                alignment = Pos.CENTER
                                add(ClientDetailView(ClientViewModel(client)))
                                button("View Client Details") {
                                    paddingAll = 10.0
                                    paddingLeft = 30.0
                                    paddingRight = 30.0
                                    action {
                                        replaceWith<ClientView>()
                                    }
                                    style {
                                        fontWeight = FontWeight.NORMAL
                                        textFill = Color.WHITE
                                        fontSize = 12.px
                                        fontFamily = "Avenir"
                                        backgroundRadius += box(8.px)
                                        backgroundColor = multi(Color.BLACK, Color.BLACK, Color.BLACK)
                                    }
                                }
                            }
                        }
                        clientList.onChange {
                            // Clear View
                            this.clear()
                            for (client in clientList) {
                                hbox {
                                    spacing = 20.0
                                    alignment = Pos.CENTER
                                    add(ClientDetailView(ClientViewModel(client)))
                                    button("View Client Details") {
                                        paddingAll = 10.0
                                        paddingLeft = 30.0
                                        paddingRight = 30.0
                                        action {
                                            replaceWith<ClientView>()
                                        }
                                        style {
                                            fontWeight = FontWeight.NORMAL
                                            textFill = Color.WHITE
                                            fontSize = 12.px
                                            fontFamily = "Avenir"
                                            backgroundRadius += box(8.px)
                                            backgroundColor = multi(Color.BLACK, Color.BLACK, Color.BLACK)
                                        }
                                    }
                                }
                            }
                        }
                    }
                    hbox{
                        form {
                            hboxConstraints {
                                marginTop = 50.0
                            }
                            style {
                                backgroundColor = multi(Color.WHITE, Color.WHITE, Color.WHITE)
                                effect = DropShadow(2.0, Color.WHITESMOKE)
                                borderColor += box(Color.WHITE)
                                borderRadius += box(8.px)
                                backgroundRadius += box(8.px)
                                paddingAll = 25.0
                                paddingRight = 40.0
                                paddingLeft = 40.0
                            }
                            label("ADD NEW CLIENT") {
                                useMaxWidth = true
                                style {
                                    fontWeight = FontWeight.EXTRA_BOLD
                                    fontSize = 16.px
                                    textFill = Color.LIGHTGRAY
                                    fontFamily = "Avenir"
                                }
                            }
                            hbox(20) {
                                fieldset {
                                    style {
                                        fontWeight = FontWeight.SEMI_BOLD
                                        fontSize = 14.px
                                        fontFamily = "Avenir"
                                    }
                                    hbox(20) {
                                        vbox {
                                            field("ID Number") {
                                                textfield(id) {
                                                    style {
                                                        fontFamily = "Avenir"
                                                        backgroundRadius += box(8.px)
                                                        borderColor += box(Color.WHITESMOKE)
                                                        borderRadius += box(8.px)
                                                        paddingAll = 10.0
                                                        backgroundColor =
                                                            multi(Color.WHITESMOKE, Color.WHITESMOKE, Color.WHITESMOKE)
                                                        effect = DropShadow(2.0, Color.WHITESMOKE)
                                                    }
                                                }
                                            }
                                            field("Client Title") {
                                                textfield(clientTitle) {
                                                    style {
                                                        fontFamily = "Avenir"
                                                        backgroundRadius += box(8.px)
                                                        borderColor += box(Color.WHITESMOKE)
                                                        borderRadius += box(8.px)
                                                        paddingAll = 10.0
                                                        backgroundColor =
                                                            multi(Color.WHITESMOKE, Color.WHITESMOKE, Color.WHITESMOKE)
                                                        effect = DropShadow(2.0, Color.WHITESMOKE)
                                                    }
                                                }
                                            }
                                        }
                                        vbox {
                                            field("First Name") {
                                                textfield(firstName) {
                                                    style {
                                                        fontFamily = "Avenir"
                                                        backgroundRadius += box(8.px)
                                                        borderColor += box(Color.WHITESMOKE)
                                                        borderRadius += box(8.px)
                                                        paddingAll = 10.0
                                                        backgroundColor =
                                                            multi(Color.WHITESMOKE, Color.WHITESMOKE, Color.WHITESMOKE)
                                                        effect = DropShadow(2.0, Color.WHITESMOKE)
                                                    }
                                                }
                                            }
                                            field("Last Name") {
                                                textfield(lastName) {
                                                    style {
                                                        fontFamily = "Avenir"
                                                        backgroundRadius += box(8.px)
                                                        borderColor += box(Color.WHITESMOKE)
                                                        borderRadius += box(8.px)
                                                        paddingAll = 10.0
                                                        backgroundColor =
                                                            multi(Color.WHITESMOKE, Color.WHITESMOKE, Color.WHITESMOKE)
                                                        effect = DropShadow(2.0, Color.WHITESMOKE)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                fieldset {
                                    style {
                                        fontWeight = FontWeight.SEMI_BOLD
                                        fontSize = 14.px
                                        fontFamily = "Avenir"
                                    }
                                    hbox(20) {
                                        vbox {
                                            field("Profile Image") {
                                                textfield(img) {
                                                    style {
                                                        fontFamily = "Avenir"
                                                        backgroundRadius += box(8.px)
                                                        borderColor += box(Color.WHITESMOKE)
                                                        borderRadius += box(8.px)
                                                        paddingAll = 10.0
                                                        backgroundColor =
                                                            multi(Color.WHITESMOKE, Color.WHITESMOKE, Color.WHITESMOKE)
                                                        effect = DropShadow(2.0, Color.WHITESMOKE)
                                                    }
                                                }
                                            }
                                            button("Add Client") {
                                                vboxConstraints {
                                                    marginLeft = 150.0
                                                    marginTop = 5.0
                                                }
                                                paddingAll = 10.0
                                                paddingLeft = 35.0
                                                paddingRight = 35.0
                                                action {
                                                    val newClient = Client(
                                                        clientTitle.value,
                                                        firstName.value,
                                                        lastName.value,
                                                        idNumber.value,
                                                        observableListOf(Account("67890827", "Gold Cheque", 2000f, 30)),
                                                        img.value
                                                    )
                                                    clientList.add(newClient)
                                                    for (client in clientList) {
                                                        println(client.firstNameProperty.value)
                                                    }
                                                }
                                                style {
                                                    fontWeight = FontWeight.NORMAL
                                                    textFill = Color.WHITE
                                                    fontSize = 12.px
                                                    fontFamily = "Avenir"
                                                    backgroundRadius += box(8.px)
                                                    backgroundColor = multi(Color.BLACK, Color.BLACK, Color.BLACK)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }

//                    form {
//                    fieldset("") {
//                        style {
//                            fontWeight = FontWeight.SEMI_BOLD
//                            textFill = Color.BLACK
//                            fontSize = 14.px
//                            fontFamily = "Avenir"
//                        }
//                        label("ADD NEW CLIENT") {
//                            useMaxWidth = true
//                            style {
//                                fontWeight = FontWeight.EXTRA_BOLD
//                                fontSize = 16.px
//                                textFill = Color.LIGHTGRAY
//                                fontFamily = "Avenir"
//                            }
//                        }
//                        field("Title") {
//                            textfield(clientTitle)
//                        }
//                        field("First Name") {
//                            textfield(firstName)
//                        }
//                        field("Last Name") {
//                            textfield(lastName)
//                        }
//                        field("ID Number") {
//                            textfield(idNumber)
//                        }
//                        field("Profile Image") {
//                            textfield(img)
//                        }
//                        button("Add Client") {
//                            paddingAll = 10.0
//                            paddingLeft = 30.0
//                            paddingRight = 30.0
//                            action {
//                                val newClient = Client(clientTitle.value, firstName.value, lastName.value, idNumber.value, observableListOf(Account("67890827", "Gold Cheque", 2000f, 30)), img.value)
//                                clientList.add(newClient)
//                                for (client in clientList) {
//                                    println(client.firstNameProperty.value)
//                                }
//                            }
//                            style {
//                                fontWeight = FontWeight.NORMAL
//                                textFill = Color.WHITE
//                                fontSize = 12.px
//                                fontFamily = "Avenir"
//                                backgroundRadius += box(8.px)
//                                backgroundColor = multi(Color.BLACK, Color.BLACK, Color.BLACK)
//                            }
//                        }
//                    }
//                }
            }
}}

