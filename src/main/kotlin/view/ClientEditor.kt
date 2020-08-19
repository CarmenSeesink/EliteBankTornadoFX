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
                textfield(model.firstName).required()
            }
            field("Last Name") {
                textfield(model.lastName).required()
            }
            field("ID Number") {
                textfield(model.id).required()
            }
        }
        button("Save") {
            setOnAction {
                model.commit()
            }
        }
    }
}