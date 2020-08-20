package account

import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

// Account Model
class Account(holderId: String, type: String, balance: Float) {
    val holderIdProperty = SimpleStringProperty(this, "holderId", holderId)
    val typeProperty = SimpleStringProperty(this, "type", type)
    val balanceProperty = SimpleFloatProperty(this,"balance", balance)
}

// Account View Model
class AccountViewModel(val account: Account): ViewModel() {
    val holderId = bind { account.holderIdProperty }
    val type = bind { account.typeProperty }
    val balance = bind { account.balanceProperty }

//    fun deposit(amount: Float) {
//       balance += amount
//    }

//    fun withdraw(amount: Float): Float {
//        return if ((balance - amount) >= 0){
//            balance - amount
//        } else {
//            -1f
//        }
//    }

//    fun applyTransactionFee(){
//        if (type == "Gold Cheque") {
//            balance += 15f
//        } else if (type == "Diamond Cheque") {
//            balance += 20f
//        }
//
//    }

//    fun applyInterest(){
//        if (type == "Tax Free Savings") {
//            balance * 0.12
//        } else if (type == "Easy Savings") {
//            balance * 0.8
//        } else {
//            balance * 1
//        }
//    }
}

// Account View
class AccountView(val model: AccountViewModel): View(){

    fun accountCardColour(): Color {
        return when(model.type.value) {
            "Gold Cheque" -> Color.DARKCYAN
            "Diamond Cheque" -> Color.GRAY
            "Easy Access Savings" -> Color.WHITE
            "Tax Free Savings" -> Color.BLACK
            else -> Color.WHITE
        }
    }

    fun accountCardTextColour(): Color {
        return when(model.type.value) {
            "Gold Cheque" -> Color.WHITE
            "Diamond Cheque" -> Color.WHITE
            "Easy Access Savings" -> Color.BLACK
            "Tax Free Savings" -> Color.WHITE
            else -> Color.WHITE
        }
    }

    fun accountCardLabel(): String {
        return when(model.type.value) {
            "Gold Cheque" ->  "Gold Cheque"
            "Diamond Cheque" ->  "Diamond Cheque"
            "Easy Access Savings" -> "Easy Access Savings"
            "Tax Free Savings" -> "Tax Free Savings"
            else -> "Account Type"
        }
    }

    override val root = stackpane {
        setMaxSize(120.0, 170.0)

        rectangle {
            stroke = Color.LIGHTGRAY
            strokeWidth = 1.0
            arcHeight = 15.0
            arcWidth = 15.0
            width = 170.0
            height = 120.0
            style {
                fill = accountCardColour()
            }
        }

        label(accountCardLabel()) {
            stackpaneConstraints {
                alignment = Pos.TOP_LEFT
                marginTop = 40.0
                marginLeft = 20.0
            }
            style {
                fontWeight = FontWeight.EXTRA_BOLD
                textFill = accountCardTextColour()
            }
        }

        label(model.balance) {
            stackpaneConstraints {
                alignment = Pos.BOTTOM_RIGHT
                marginRight = 20.0
                marginBottom = 40.0
            }
            style {
                fontWeight = FontWeight.EXTRA_BOLD
                textFill = accountCardTextColour()
            }
        }

    }
}