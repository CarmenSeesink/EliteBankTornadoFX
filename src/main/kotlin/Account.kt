import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

// Account Model
class Account(firstName: String, type: String, balance: Float, freeTransactions: Int) {
    val firstNameProperty = SimpleStringProperty(this, "firstName", firstName)
    val typeProperty = SimpleStringProperty(this, "type", type)
    val balanceProperty = SimpleFloatProperty(this,"balance", balance)
    val freeTransactionsProperty = SimpleIntegerProperty(this,"freeTransactions", freeTransactions)
}

// Account View Model
class AccountViewModel(val account: Account): ViewModel() {
    val firstName = bind { account.firstNameProperty }
    val type = bind { account.typeProperty }
    val balance = bind { account.balanceProperty }
    val freeTransactions = bind { account.freeTransactionsProperty }

    fun deposit(amount: Float) {
        balance.value += amount
    }

    fun withdraw(amount: Float): Float {
        if ((balance - amount) >= 0){
            balance.value -= amount
            return balance.value
        } else {
            return -1f
        }
    }

    fun transfer(amount: Float): Float {
        if ((balance - amount) >= 0){
            balance.value -= amount
            return balance.value
        } else {
            return -1f
        }
    }

    fun transferTo(amount: Float) {

    }

    fun applyTransactionFee(){
        if (freeTransactions.value <= 0 && type.value == "Gold Cheque") {
            balance.value -= 15f
        } else if (freeTransactions.value <= 0 && type.value == "Diamond Cheque") {
            balance.value -= 12f
        }
    }

    fun applyInterest(){
        if (type.value == "Tax Free Savings") {
            val interest = balance * 0.12
            balance.value += interest.value.toFloat()
        } else if (type.value == "Easy Savings") {
            val interest = balance * 0.8
            balance.value += interest.value.toFloat()
        } else {
            balance.plus(balance * 1)
        }
    }

    fun resetFreeTransactions(){
        if (type.value == "Gold Cheque") {
            freeTransactions.value = 10
        } else if (type.value == "Diamond Cheque") {
            freeTransactions.value = 30
        }
    }
}

// Account View
class AccountView(val accountViewModel: AccountViewModel): View() {

    val depositAmount = SimpleFloatProperty()
    val withDrawnAmount = SimpleFloatProperty()
    val transferAmount = SimpleFloatProperty()
    val transferAccount = SimpleStringProperty()
    val firstName = SimpleStringProperty()
    val type = SimpleStringProperty()
    val balance = SimpleFloatProperty()

    fun accountCardColour(): Color {
        return when (accountViewModel.type.value) {
            "Gold Cheque" -> Color.BLACK
            "Diamond Cheque" -> Color.GRAY
            "Easy Access Savings" -> Color.WHITE
            "Tax Free Savings" -> Color.DARKGRAY
            else -> Color.WHITE
        }
    }

    fun accountCardBorderColour(): Color {
        return when (accountViewModel.type.value) {
            "Gold Cheque" -> Color.BLACK
            "Diamond Cheque" -> Color.GRAY
            "Easy Access Savings" -> Color.LIGHTGRAY
            "Tax Free Savings" -> Color.DARKGRAY
            else -> Color.WHITE
        }
    }

    fun accountCardTextColour(): Color {
        return when (accountViewModel.type.value) {
            "Gold Cheque" -> Color.WHITE
            "Diamond Cheque" -> Color.WHITE
            "Easy Access Savings" -> Color.BLACK
            "Tax Free Savings" -> Color.WHITE
            else -> Color.WHITE
        }
    }

    fun accountCardLabel(): String {
        return when (accountViewModel.type.value) {
            "Gold Cheque" -> "Gold Cheque"
            "Diamond Cheque" -> "Diamond Cheque"
            "Easy Access Savings" -> "Easy Access Savings"
            "Tax Free Savings" -> "Tax Free Savings"
            else -> "Account Type"
        }
    }

    override val root = hbox {
        spacing = 20.0
        hboxConstraints {
            alignment = Pos.CENTER_LEFT
        }
        stackpane {
            effect = DropShadow(2.0, Color.WHITESMOKE)
            rectangle {
                stackpaneConstraints {
                    alignment = Pos.TOP_LEFT
                }
                arcHeight = 18.0
                arcWidth = 18.0
                width = 350.0
                height = 330.0
                strokeWidth = 1.0
                fill = Color.WHITE
            }
            vbox {
                spacing = 10.0
                paddingLeft = 25.0
                paddingTop = 25.0
                vboxConstraints {
                    alignment = Pos.TOP_LEFT
                }
                stackpane {
                    setMaxSize(120.0, 170.0)
                    rectangle {
                        stroke = accountCardBorderColour()
                        strokeWidth = 1.0
                        arcHeight = 15.0
                        arcWidth = 15.0
                        width = 300.0
                        height = 180.0
                        style {
                            fill = accountCardColour()
                        }
                    }

                    label("ELITE BANK") {
                        stackpaneConstraints {
                            alignment = Pos.TOP_LEFT
                            marginTop = 20.0
                            marginLeft = 20.0
                        }
                        style {
                            fontWeight = FontWeight.BOLD
                            textFill = accountCardTextColour()
                            fontSize = 12.px
                            fontFamily = "Avenir"
                        }
                    }

                    label("• • •   • • •   • • 8 7 9") {
                        stackpaneConstraints {
                            alignment = Pos.CENTER
                        }
                        style {
                            fontWeight = FontWeight.BOLD
                            textFill = accountCardTextColour()
                            fontSize = 22.px
                            fontFamily = "Avenir"
                        }
                    }
                    label("EXP 04/22") {
                        stackpaneConstraints {
                            alignment = Pos.BOTTOM_LEFT
                            marginBottom = 20.0
                            marginLeft = 20.0
                        }
                        style {
                            fontWeight = FontWeight.SEMI_BOLD
                            textFill = accountCardTextColour()
                            fontSize = 12.px
                            fontFamily = "Avenir"
                        }
                    }
                    label(accountCardLabel()) {
                        stackpaneConstraints {
                            alignment = Pos.BOTTOM_RIGHT
                            marginBottom = 20.0
                            marginRight = 20.0
                        }
                        style {
                            fontWeight = FontWeight.EXTRA_BOLD
                            textFill = accountCardTextColour()
                            fontSize = 16.px
                            fontFamily = "Avenir"
                        }
                    }
                }
                hbox {
                    spacing = 27.0
                    vbox{
                        label("Account Balance"){
                            style {
                                fontWeight = FontWeight.EXTRA_BOLD
                                fontSize = 18.px
                                fontFamily = "Avenir"
                            }
                        }
                        label("R ${accountViewModel.balance.value}0") {
                            accountViewModel.balance.onChange {
                                text = "R ${it}0"
                            }
                            style {
                                fontWeight = FontWeight.BOLD
                                fontSize = 16.px
                                fontFamily = "Avenir"
                            }
                        }
                    }
                    button("Close off") {
                        paddingAll = 10.0
                        paddingLeft = 35.0
                        paddingRight = 35.0
                        action {
                            accountViewModel.applyInterest()
                            accountViewModel.resetFreeTransactions()
                            println("Balance after Interest: ${accountViewModel.balance.value}")
                        }
                        style {
                            fontWeight = FontWeight.NORMAL
                            textFill = Color.BLACK
                            fontSize = 12.px
                            borderWidth += box(1.5.px)
                            fontFamily = "Avenir"
                            backgroundRadius += box(8.px)
                            borderColor += box(Color.BLACK)
                            borderRadius += box(8.px)
                            backgroundColor = multi(Color.WHITE, Color.WHITE, Color.WHITE)
                        }
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
        form {
            style {
                backgroundColor = multi(Color.WHITE,Color.WHITE,Color.WHITE)
                effect = DropShadow(2.0, Color.WHITESMOKE)
                borderColor += box(Color.WHITE)
                borderRadius += box(8.px)
                backgroundRadius += box(8.px)
                paddingAll = 25.0
                paddingRight = 35.0
            }
            label(accountViewModel.type.value){
                style {
                    fontWeight = FontWeight.EXTRA_BOLD
                    fontSize = 18.px
                    fontFamily = "Avenir"
                    textFill = Color.LIGHTGRAY
                    paddingBottom = 40.0
                }
            }
            hbox(20) {
                fieldset("Deposit") {
                    style {
                        fontWeight = FontWeight.SEMI_BOLD
                        fontSize = 14.px
                        fontFamily = "Avenir"
                    }
                    hbox(25) {
                        vbox {
                            field("Ammount") {
                                textfield(depositAmount) {
                                    style {
                                        fontFamily = "Avenir"
                                        backgroundRadius += box(8.px)
                                        borderColor += box(Color.WHITESMOKE)
                                        borderRadius += box(8.px)
                                        paddingAll = 10.0
                                        backgroundColor = multi(Color.WHITESMOKE, Color.WHITESMOKE, Color.WHITESMOKE)
                                        effect = DropShadow(2.0, Color.WHITESMOKE)
                                    }
                                }
                            }
                            field("Description") {
                                textfield() {
                                    style {
                                        fontFamily = "Avenir"
                                        backgroundRadius += box(8.px)
                                        borderColor += box(Color.WHITESMOKE)
                                        borderRadius += box(8.px)
                                        paddingAll = 10.0
                                        backgroundColor = multi(Color.WHITESMOKE, Color.WHITESMOKE, Color.WHITESMOKE)
                                        effect = DropShadow(2.0, Color.WHITESMOKE)
                                    }
                                }
                            }
                            button("Deposit") {
                                vboxConstraints {
                                    marginLeft = 150.0
                                    marginTop = 20.0
                                }
                                paddingAll = 10.0
                                paddingLeft = 35.0
                                paddingRight = 35.0
                                action {
                                    accountViewModel.deposit(depositAmount.value)
                                    println("New Balance: ${accountViewModel.balance.value}")
                                }
                                style {
                                    fontWeight = FontWeight.NORMAL
                                    textFill = Color.WHITE
                                    fontSize = 12.px
                                    fontFamily = "Avenir"
                                    backgroundRadius += box(8.px)
                                    backgroundColor = multi(Color.BLACK, Color.BLACK, Color.BLACK)
                                }
                            }
                        }
                    }
                }
                fieldset("Withdraw") {
                    style {
                        fontWeight = FontWeight.SEMI_BOLD
                        fontSize = 14.px
                        fontFamily = "Avenir"
                    }
                    field("Ammount") {
                            textfield(withDrawnAmount) {
                                style {
                                    fontFamily = "Avenir"
                                    backgroundRadius += box(8.px)
                                    borderColor += box(Color.WHITESMOKE)
                                    borderRadius += box(8.px)
                                    paddingAll = 10.0
                                    backgroundColor = multi(Color.WHITESMOKE, Color.WHITESMOKE, Color.WHITESMOKE)
                                    effect = DropShadow(2.0, Color.WHITESMOKE)
                                }
                            }
                        }
                        field("Description") {
                            textfield() {
                                style {
                                    fontFamily = "Avenir"
                                    backgroundRadius += box(8.px)
                                    borderColor += box(Color.WHITESMOKE)
                                    borderRadius += box(8.px)
                                    paddingAll = 10.0
                                    backgroundColor = multi(Color.WHITESMOKE, Color.WHITESMOKE, Color.WHITESMOKE)
                                    effect = DropShadow(2.0, Color.WHITESMOKE)
                                }
                            }
                        }
                    button("Withdraw") {
                        vboxConstraints {
                            marginLeft = 150.0
                            marginTop = 20.0
                        }
                        paddingAll = 10.0
                        paddingLeft = 32.0
                        paddingRight = 32.0
                        action {
                            val withdrawn = accountViewModel.withdraw(withDrawnAmount.value)
                            val applyFee = accountViewModel.applyTransactionFee()
                            println("Withdrawal: ${withdrawn}")
                            println("Withdrawal: ${applyFee}")
                        }
                        style {
                            fontWeight = FontWeight.NORMAL
                            textFill = Color.WHITE
                            fontSize = 12.px
                            fontFamily = "Avenir"
                            backgroundRadius += box(8.px)
                            backgroundColor = multi(Color.BLACK, Color.BLACK, Color.BLACK)
                        }
                    }
                }
                fieldset("Transfer") {
                    style {
                        fontWeight = FontWeight.SEMI_BOLD
                        fontSize = 14.px
                        fontFamily = "Avenir"
                    }
                    field("Ammount") {
                        textfield(transferAmount) {
                            style {
                                fontFamily = "Avenir"
                                backgroundRadius += box(8.px)
                                borderColor += box(Color.WHITESMOKE)
                                borderRadius += box(8.px)
                                paddingAll = 10.0
                                backgroundColor = multi(Color.WHITESMOKE, Color.WHITESMOKE, Color.WHITESMOKE)
                                effect = DropShadow(2.0, Color.WHITESMOKE)
                            }
                        }
                    }
                    field("Account") {
                        textfield(transferAccount) {
                            style {
                                fontFamily = "Avenir"
                                backgroundRadius += box(8.px)
                                borderColor += box(Color.WHITESMOKE)
                                borderRadius += box(8.px)
                                paddingAll = 10.0
                                backgroundColor = multi(Color.WHITESMOKE, Color.WHITESMOKE, Color.WHITESMOKE)
                                effect = DropShadow(2.0, Color.WHITESMOKE)
                            }
                        }
                    }
                    button("Transfer") {
                        vboxConstraints {
                            marginLeft = 150.0
                            marginTop = 20.0
                        }
                        paddingAll = 10.0
                        paddingLeft = 35.0
                        paddingRight = 35.0
                        action {
                            val transfer = accountViewModel.transfer(transferAmount.value)
//                        val transferTo = accountViewModel.transferTo("")
                            println("Transfer: ${transfer}")
                        }
                        style {
                            fontWeight = FontWeight.NORMAL
                            textFill = Color.WHITE
                            fontSize = 12.px
                            fontFamily = "Avenir"
                            backgroundRadius += box(8.px)
                            backgroundColor = multi(Color.BLACK, Color.BLACK, Color.BLACK)
                        }
                    }
                }
            }
        }
    }
}

