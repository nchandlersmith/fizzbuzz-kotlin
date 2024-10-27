package org.example

class App {
    fun fizzBuzz(number: Number): String {
        if (2 == number) {
            return "Fizz"
        }
        return number.toString()
    }
}

fun main() {
    println("Main invoked.")
}
