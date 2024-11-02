package org.example

class App {
    fun run(inputString: String): String {
        val number = inputString.toInt()
        return fizzBuzz(number)
    }
}

fun fizzBuzz(number: Int): String {
    var returnString = ""
    if (0 == number % 3) {
        returnString += "Fizz"
    }
    if (0 == number % 5) {
        returnString += "Buzz"
    }
    if (returnString == "") {
        return number.toString()
    }
    return returnString

}

fun main() {
    println("Main invoked.")
}
