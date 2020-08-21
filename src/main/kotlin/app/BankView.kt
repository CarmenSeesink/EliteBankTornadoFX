package app

import account.Account
import account.AccountView
import account.AccountViewModel
import bank.Bank
import bank.BankViewModel
import client.Client
import client.ClientEditor
import client.ClientView
import client.ClientViewModel
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class BankView: View("Elite Bank") {

    val bankViewModel = BankViewModel(Bank())

    override val root =
            borderpane {
                style {
                    backgroundColor += Color.WHITE
                }
                setPrefSize(1440.0, 960.0)
                paddingAll = 40.0
                top = label("Elite Bank") {
                    useMaxWidth = true
                    style {
                        fontWeight = FontWeight.BOLD
                        fontSize = 30.px
                        fontFamily = "Source Sans Pro"
                    }
                }
                left = vbox {
                    paddingAll = 25.0
                    label("Our Clients") {
                        useMaxWidth = true
                        style {
                            fontWeight = FontWeight.NORMAL
                            fontSize = 20.px
                            fontFamily = "Source Sans Pro"
                        }
                        vboxConstraints {
                            marginTop = 20.0
                            marginBottom = 20.0
                        }
                    }
                    hbox {
                        spacing = 50.0
                        hboxConstraints {
                            alignment = Pos.CENTER_LEFT
                        }
                        stackpane {
                            hbox {
                                spacing = 150.0
                                paddingLeft = 40.0
                                hboxConstraints {
                                    alignment = Pos.CENTER_LEFT
                                }
                                label("First Name") {
                                    style {
                                        fontWeight = FontWeight.THIN
                                        fontSize = 14.px
                                        fontFamily = "Source Sans Pro"
                                    }
                                }
                                label("Last Name") {
                                    style {
                                        fontWeight = FontWeight.THIN
                                        fontSize = 14.px
                                        fontFamily = "Source Sans Pro"
                                    }
                                }
                                label("ID Number") {
                                    style {
                                        fontWeight = FontWeight.THIN
                                        fontSize = 14.px
                                        fontFamily = "Source Sans Pro"
                                    }
                                }
//                            button("Withdraw") {
//                                paddingAll = 10.0
//                                paddingLeft = 30.0
//                                paddingRight = 30.0
//                                action {
//                                    bankViewModel.closeOffMonth()
//                                }
//                                style{
//                                    fontWeight = FontWeight.NORMAL
//                                    textFill = Color.WHITE
//                                    fontSize = 12.px
//                                    fontFamily = "Source Sans Pro"
//                                    backgroundRadius += box(8.px)
//                                    backgroundColor = multi(Color.CORNFLOWERBLUE, Color.CORNFLOWERBLUE, Color.CORNFLOWERBLUE)
//                                }
//                            }
//                            button("Transfer") {
//                                paddingAll = 10.0
//                                paddingLeft = 30.0
//                                paddingRight = 30.0
//                                action {
//                                    bankViewModel.closeOffMonth()
//                                }
//                                style{
//                                    fontWeight = FontWeight.NORMAL
//                                    textFill = Color.WHITE
//                                    fontSize = 12.px
//                                    fontFamily = "Source Sans Pro"
//                                    backgroundRadius += box(8.px)
//                                    backgroundColor = multi(Color.CORNFLOWERBLUE, Color.CORNFLOWERBLUE, Color.CORNFLOWERBLUE)
//                                }
//                            }
//                            add(AccountView(AccountViewModel(Account("67890827", "Gold Cheque", 2000f))))
//                            add(AccountView(AccountViewModel(Account("67890827", "Diamond Cheque", 5000f))))
//                            add(AccountView(AccountViewModel(Account("67890827", "Easy Access Savings", 1000f))))
//                            add(AccountView(AccountViewModel(Account("67890827", "Tax Free Savings", 1400f))))

                            }
                            rectangle {
                                arcHeight = 18.0
                                arcWidth = 18.0
                                width = 700.0
                                height = 60.0
                                stroke = Color.LIGHTGRAY
                                strokeWidth = 1.0
                                fill = Color.TRANSPARENT
                            }
                        }
                        button("View Client Details") {
                            paddingAll = 10.0
                            paddingLeft = 30.0
                            paddingRight = 30.0
                            action {
                                replaceWith<ClientView>()
                            }
                            style{
                                fontWeight = FontWeight.NORMAL
                                textFill = Color.WHITE
                                fontSize = 12.px
                                fontFamily = "Source Sans Pro"
                                backgroundRadius += box(8.px)
                                backgroundColor = multi(Color.CORNFLOWERBLUE, Color.CORNFLOWERBLUE, Color.CORNFLOWERBLUE)
                            }
                        }
                    }
                }

                right = hbox{
                    paddingRight = 50.0
                    spacing = 20.0
                    textfield() {
                        style{
                            fontWeight = FontWeight.NORMAL
                            fontSize = 12.px
                            paddingAll = 10.0
                            fontFamily = "Source Sans Pro"
                            borderRadius += box(8.px)
                            borderColor += box(Color.LIGHTGRAY)
                            backgroundRadius += box(8.px)
                            backgroundColor = multi(Color.WHITE)
                        }
                    }
                    button("Search Client") {
                        paddingAll = 10.0
                        paddingLeft = 30.0
                        paddingRight = 30.0
                        action {  }
                        style{
                            fontWeight = FontWeight.NORMAL
                            textFill = Color.WHITE
                            fontSize = 12.px
                            fontFamily = "Source Sans Pro"
                            backgroundRadius += box(8.px)
                            backgroundColor = multi(Color.CORNFLOWERBLUE, Color.CORNFLOWERBLUE, Color.CORNFLOWERBLUE)
                        }
                    }
                }
            }
}

