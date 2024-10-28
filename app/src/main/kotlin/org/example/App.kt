package org.example

class App {
    fun fizzBuzz(number: Int): String {
        if (0 == number % 3) {
            return "Fizz"
        }
        if (0 == number % 5) {
            return "Buzz"
        }
        return number.toString()
    }
}

fun main() {
    println("Main invoked.")
}
