package models

open class Account (val holderId: Int, val type: String, var balance: Float ) {

    fun deposit(amount: Float) {
        balance += amount
    }

    fun withdraw(amount: Float): Float {
        return if (( balance - amount >=0 )){
            balance - amount
        } else {
            -1f
        }
    }

    fun closeOff() {
        println("Withdraw")
    }
}