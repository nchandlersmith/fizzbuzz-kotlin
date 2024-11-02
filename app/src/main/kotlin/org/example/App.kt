package org.example

import jdk.dynalink.Operation

class App {
    fun run(inputString: String): String {
        val number = inputString.toInt()
        return fizzBuzz(number)
    }
}

fun fizzBuzz(number: Int): String {
    var returnString = ""
    val rules = listOf(fizzRule, buzzRule)
    for (rule in rules) {
        returnString = rule(number, returnString)
    }

    if (returnString == "") {
        return number.toString()
    }
    return returnString
}

val fizzRule: (Int, String) -> String = { number, currentString ->
    rule(number, currentString, "Fizz", fun (number): Boolean {
        return 0 == number % 3
    })
}

val buzzRule: (Int, String) -> String = { number, currentString ->
    rule(number, currentString, "Buzz", fun (number): Boolean {
        return 0 == number % 5
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
