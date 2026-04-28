package utils

import kotlin.test.assertTrue

object Assertions {

    fun assertPositivePrice(price: Double) {
        assertTrue(price > 0, "Price should be positive")
    }
}