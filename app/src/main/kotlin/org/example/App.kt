package org.example

class App {
    fun fizzBuzz(number: Int): String {
        if (0 == number % 2) {
            return "Fizz"
        }
        return number.toString()
    }
}

fun main() {
    println("Main invoked.")
}
