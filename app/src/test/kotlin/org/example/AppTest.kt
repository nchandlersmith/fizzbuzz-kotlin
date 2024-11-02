package org.example

import io.kotest.core.spec.style.FunSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.int
import io.kotest.property.forAll

class AppTest : FunSpec ({
    test("fizzBuzz given 1 returns 1") {
        val app = App()
        val divisibleBy3Not5 = Arb.int(1..100).filter { it % 3 != 0 && it % 5 != 0 }
        forAll(divisibleBy3Not5) { n ->
            n.toString() == app.run(n)
        }
    }
    test("fizzBuzz given number divisible by 3 return Fizz") {
        val app = App()
        val divisibleBy3Not5 = Arb.int(1..100).filter { it % 3 == 0 && it % 5 != 0 }
        forAll(divisibleBy3Not5) { n ->
            "Fizz" == app.run(n)
        }
    }
    test("fizzBuzz given number divisible by 5 return Buzz") {
        val app = App()
        val divisibleBy5Not3 = Arb.int(1..100).filter { it % 5 == 0 && it % 3 != 0 }
        forAll(divisibleBy5Not3) { n ->
            "Buzz" == app.run(n)
        }
    }
    test("fizzBuzz given number divisible by 3 & 5 return Buzz") {
        val app = App()
        val divisibleBy5Not3 = Arb.int(1..100).filter { it % 5 == 0 && it % 3 == 0 }
        forAll(divisibleBy5Not3) { n ->
            "FizzBuzz" == app.run(n)
        }
    }
})
