package org.example

class App {
    fun run(inputString: String): String {
        val number = inputString.toInt()
        return fizzBuzz(number)
    }
}

fun fizzBuzz(number: Int): String {
    var returnString = ""

    returnString = rule(number, returnString, "Fizz", fun (number): Boolean {
        return 0 == number % 3
    })
    returnString = rule(number, returnString, "Buzz", fun (number): Boolean {
        return 0 == number % 5
    })
    if (returnString == "") {
        return number.toString()
    }
    return returnString
}

fun rule(number:Int, stringIn: String, modifier:String, check: (Int) -> Boolean): String {
    if (check(number)) {
        val newString = stringIn + modifier
        return newString
    }
    return stringIn
}

fun main() {
    println("Main invoked.")
}
