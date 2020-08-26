import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

// Client Container for List
class ClientDetailView(val clientViewModel: ClientViewModel): View() {

    val firstName = SimpleStringProperty()

    override val root = hbox {
        spacing = 80.0
        hboxConstraints {
            alignment = Pos.CENTER_LEFT
        }
        stackpane {
            effect = DropShadow(2.0, Color.WHITESMOKE)
            rectangle {
                arcHeight = 18.0
                arcWidth = 18.0
                width = 1000.0
                height = 100.0
                strokeWidth = 1.0
                fill = Color.WHITE
            }
            hbox {
                spacing = 100.0
                paddingLeft = 40.0
                hboxConstraints {
                    alignment = Pos.CENTER_LEFT
                }
                imageview(clientViewModel.img.value) {
                    fitHeight = 80.0
                    fitWidth = 80.0
                    paddingLeft = 10
                    isPreserveRatio = true
                }
                label(clientViewModel.title.value) {
                    style {
                        fontWeight = FontWeight.NORMAL
                        fontSize = 14.px
                        textFill = Color.BLACK
                        fontFamily = "Avenir"
                    }
                }
                label(clientViewModel.firstName.value) {
                    style {
                        fontWeight = FontWeight.NORMAL
                        fontSize = 14.px
                        textFill = Color.BLACK
                        fontFamily = "Avenir"
                    }
                }
                label(clientViewModel.lastName.value) {
                    style {
                        fontWeight = FontWeight.NORMAL
                        fontSize = 14.px
                        fontFamily = "Avenir"
                        textFill = Color.BLACK
                    }
                }
                label(clientViewModel.id.value) {
                    style {
                        fontWeight = FontWeight.NORMAL
                        fontSize = 14.px
                        fontFamily = "Avenir"
                        textFill = Color.BLACK
                    }
                }
                hbox {
                    alignment = Pos.CENTER_LEFT
                    spacing = 10.0
                    label("•"){
                        style {
                            fontWeight = FontWeight.EXTRA_BOLD
                            fontSize = 20.px
                            fontFamily = "Avenir"
                            textFill = Color.MEDIUMSEAGREEN
                        }
                    }
                    label("Active"){
                        style {
                            fontWeight = FontWeight.SEMI_BOLD
                            fontSize = 14.px
                            fontFamily = "Avenir"
                        }
                    }
                }
            }
        }
    }
}