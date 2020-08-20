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
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class BankView: View("Elite Bank") {

    val bankViewModel = BankViewModel(Bank())

    override val root =
            borderpane {
                setPrefSize(1440.0, 960.0)
                paddingAll = 10.0
                top = label("Welcome to Elite Bank") {
                    useMaxWidth = true
                    style {
                        fontWeight = FontWeight.BOLD
                        textFill = Color.BLACK
                        fontSize = 30.px
                    }
                }

                left = vbox {
                    label("Our Clients") {
                        useMaxWidth = true
                        style {
                            fontWeight = FontWeight.NORMAL
                            textFill = Color.BLACK
                            fontSize = 20.px
                        }
                        vboxConstraints {
                            marginTop = 20.0
                            marginBottom = 20.0
                        }
                    }
                    stackpane {
                        hbox {
                            spacing = 10.0
                            vbox {
                                label("Name")
                                label("839304940")
                            }
                            button("Deposit") {
                                action {
                                    bankViewModel.closeOffMonth()
                                }
                            }
                            button("Withdraw") {
                                action {
                                    bankViewModel.closeOffMonth()
                                }
                            }
                            button("Transfer") {
                                action {
                                    bankViewModel.closeOffMonth()
                                }
                            }
                            add(AccountView(AccountViewModel(Account("67890827", "Gold Cheque", 2000f))))
                            add(AccountView(AccountViewModel(Account("67890827", "Diamond Cheque", 5000f))))
                            add(AccountView(AccountViewModel(Account("67890827", "Easy Access Savings", 1000f))))
                            add(AccountView(AccountViewModel(Account("67890827", "Tax Free Savings", 1400f))))

                        }
                        rectangle {
                            arcHeight = 15.0
                            arcWidth = 15.0
                            width = 1200.0
                            height = 150.0
                            stroke = Color.LIGHTGRAY
                            strokeWidth = 1.0
                            fill = Color.TRANSPARENT
                        }
                    }
                }
            }
}

