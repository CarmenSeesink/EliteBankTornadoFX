package app
import javafx.stage.Stage
import tornadofx.*

class MainBank: App(BankView::class) {
    override fun start(stage: Stage) {
        with(stage){
            minWidth = 1024.0
            height = 720.0
            super.start(stage)
        }

    }
}