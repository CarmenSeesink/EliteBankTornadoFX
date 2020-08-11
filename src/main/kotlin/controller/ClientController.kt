package controller

import javafx.collections.FXCollections
import tornadofx.Controller
import models.Client

class ClientController : Controller() {
    val clients = FXCollections.observableArrayList<Client>()

    init {
        clients += Client("John", "Smith", "98909897990")
        clients += Client("John", "Smith", "98909897990")
        clients += Client("John", "Smith", "98909897990")
    }
}