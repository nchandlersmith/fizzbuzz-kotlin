package org.example

import arrow.core.getOrElse
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.int
import io.kotest.property.forAll

class AppTest : FunSpec ({
    test("fizzBuzz indivisible by 3 or 5 returns number as string") {
        val app = App()
        val divisibleBy3Not5 = Arb.int(1..100).filter { it % 3 != 0 && it % 5 != 0 }
        forAll(divisibleBy3Not5) { n ->
            app.run(n.toString()).getOrElse { "" } == n.toString()
        }
    }
    test("fizzBuzz given number divisible by 3 return Fizz") {
        val app = App()
        val divisibleBy3Not5 = Arb.int(1..100).filter { it % 3 == 0 && it % 5 != 0 }
        forAll(divisibleBy3Not5) { n ->
            app.run(n.toString()).getOrElse { "" } == "Fizz"
        }
    }
    test("fizzBuzz given number divisible by 5 return Buzz") {
        val app = App()
        val divisibleBy5Not3 = Arb.int(1..100).filter { it % 5 == 0 && it % 3 != 0 }
        forAll(divisibleBy5Not3) { n ->
            app.run(n.toString()).getOrElse { "" } == "Buzz"
        }
    }
    test("fizzBuzz given number divisible by 3 & 5 return Buzz") {
        val app = App()
        val divisibleBy5Not3 = Arb.int(1..100).filter { it % 5 == 0 && it % 3 == 0 }
        forAll(divisibleBy5Not3) { n ->
            app.run(n.toString()).getOrElse { "" } == "FizzBuzz"
        }
    }
})
