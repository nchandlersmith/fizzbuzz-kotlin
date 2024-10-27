package org.example

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class AppTest {
    @Test
    fun `fizzBuzz given 1 returns 1`() {
        val app = App()
        val result = app.fizzBuzz(1)
        result shouldBe "1"
    }
}
