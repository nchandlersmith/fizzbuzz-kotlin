package org.example

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.int
import io.kotest.property.forAll

class AppTest : FunSpec ({
    test("fizzBuzz given 1 returns 1") {
        val app = App()
        val result = app.fizzBuzz(1)
        result shouldBe "1"
    }
    test("fizzBuzz given even number return Fizz") {
        val app = App()
        val evens = Arb.int(1..100).filter { it % 2 == 0 }
        forAll(evens) { n ->
            "Fizz" == app.fizzBuzz(n)
        }
    }
})
