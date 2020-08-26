import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

// Account Holder
class AccountHolderView (val clientViewModel: ClientViewModel): View() {

    override val root =  hbox {
        spacing = 40.0
        paddingBottom = 20.0
        imageview("1.png") {
            fitHeight = 100.0
            fitWidth = 100.0
            paddingLeft = 5
            isPreserveRatio = true
        }
        vbox {
            hbox {
                vboxConstraints {
                    marginTop = 10.0
                    marginBottom = 10.0
                }
                spacing = 5.0
                label(clientViewModel.firstName.value) {
                    useMaxWidth = true
                    style {
                        fontWeight = FontWeight.EXTRA_BOLD
                        fontSize = 18.px
                        fontFamily = "Avenir"
                    }
                }
                label(clientViewModel.lastName.value) {
                    useMaxWidth = true
                    style {
                        fontWeight = FontWeight.EXTRA_BOLD
                        fontSize = 18.px
                        fontFamily = "Avenir"
                    }
                }
            }
            label(clientViewModel.id.value) {
                useMaxWidth = true
                style {
                    fontWeight = FontWeight.SEMI_BOLD
                    fontSize = 16.px
                    textFill = Color.LIGHTGRAY
                    fontFamily = "Avenir"
                }
                vboxConstraints {
                    marginBottom = 5.0
                }
            }
        }
    }
}