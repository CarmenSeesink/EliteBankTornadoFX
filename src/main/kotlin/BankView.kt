import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*
import java.time.LocalDate
import java.time.Period

class BankView: View("BlackJack") {
    var showText = true

    private val persons = listOf(
        Person(1,"Samantha Stuart",LocalDate.of(1981,12,4)),
        Person(2,"Tom Marks",LocalDate.of(2001,1,23)),
        Person(3,"Stuart Gills",LocalDate.of(1989,5,23)),
        Person(3,"Nicole Williams",LocalDate.of(1998,8,11))
    ).asObservable()

    override val root = vbox {
        setPrefSize(1440.0, 960.0)
        label("This is the BlackJack Game"){
            hboxConstraints {
                alignment = Pos.CENTER
            }
            textFill = c("#555555")
            style {
                backgroundColor += Color.AQUA
            }
            isVisible = showText
        }
        tableview(persons) {
            readonlyColumn("ID",Person::id)
            readonlyColumn("Name", Person::name)
            readonlyColumn("Birthday", Person::birthday)
            readonlyColumn("Age",Person::age)
        }
    }
}

class Person(val id: Int, val name: String, val birthday: LocalDate) {
    val age: Int get() = Period.between(birthday, LocalDate.now()).years
}