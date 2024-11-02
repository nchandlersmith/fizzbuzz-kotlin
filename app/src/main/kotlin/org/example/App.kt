package org.example

class App {
    fun run(inputString: String): String {
        val number = inputString.toInt()
        return fizzBuzz(number)
    }
}

fun fizzBuzz(number: Int): String {
    var returnString = ""

    returnString = fizzRule(number, returnString)
    returnString = buzzRule(number, returnString)
    if (returnString == "") {
        return number.toString()
    }
    return returnString
}

fun buzzRule(number: Int, currentString: String) : String {
    return rule(number, currentString, "Buzz", fun (number): Boolean {
        return 0 == number % 5
    })
}

fun fizzRule(number: Int, currentString: String) : String {
    return rule(number, currentString, "Fizz", fun (number): Boolean {
        return 0 == number % 3
    })
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
