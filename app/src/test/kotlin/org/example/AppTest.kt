package org.example

import kotlin.test.Test
import kotlin.test.assertEquals

class AppTest {
    @Test
    fun fizzBuzz_given1_return1() {
        val app = App()
        val result = app.fizzBuzz(1)
        assertEquals("1", result)
    }
}
