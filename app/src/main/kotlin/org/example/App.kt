package org.example

import arrow.core.Either

class App {
    fun run(inputString: String): Either<InputError, String> {
        val number = inputString.toIntOrNull()
        if (number == null) {
            return Either.Left(InputError("Input: [%s] is not a valid integer.".format(inputString)))
        }
        return Either.Right(fizzBuzz(number))
    }
}

class InputError(val message: String)

fun fizzBuzz(number: Int): String {
    var returnString = ""
    val rules = listOf(fizzRule, buzzRule)
    for (rule in rules) {
        returnString = rule(number, returnString)
    }
    returnString = indivisibleRule(returnString, number)
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

fun indivisibleRule(returnString: String, number: Int): String {
    var returnString1 = returnString
    if (returnString1 == "") {
        returnString1 = number.toString()
    }
    return returnString1
}

fun main() {
    println("Enter a number")
    val number = readLine()
    App().run(number!!).fold(
        { error -> println(error.message) },
        { println(it) }
    )
}
