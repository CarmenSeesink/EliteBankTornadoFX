package controller

import javafx.collections.FXCollections
import models.Account
import models.Client
import tornadofx.*

class ClientController : Controller() {
    val clients = FXCollections.observableArrayList<Client>()

    init {
        clients += Client(1,"John", "Smith", "98909897990", listOf(
                Account(1, "Gold", 1000f),
                Account(1, "Diamond",200f )
        ).asObservable())
        clients += Client(2,"John", "Smith", "98909897990", listOf(
                Account(2, "Gold", 1000f),
                Account(2, "Diamond",200f )
        ).asObservable())
        clients += Client(3,"John", "Smith", "98909897990", listOf(
                Account(3, "Gold", 1000f),
                Account(3, "Diamond",200f )
        ).asObservable())
    }
}