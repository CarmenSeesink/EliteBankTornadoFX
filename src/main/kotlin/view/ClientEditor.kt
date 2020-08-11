package view

import javafx.scene.layout.Priority
import tornadofx.*
import models.ClientModel

class ClientEditor : View() {
    val model : ClientModel by inject()

    override val root = form {
        prefWidth = 300.0
        hboxConstraints { hGrow = Priority.ALWAYS }
        fieldset {
            field("First Name") {
                textfield(model.firstName)
            }
            field("Last Name") {
                textfield(model.lastName)
            }
            field("ID Number") {
                textfield(model.id)
            }
        }
        button("Save") {
            setOnAction {
                model.commit()
            }
        }
    }
}