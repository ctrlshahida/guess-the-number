package com.example.guessthenumber
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class NumberGameTest {

    private lateinit var numberGame: NumberGame

    @Before
    fun setup() {
        numberGame = NumberGame()
    }

    @Test
    fun `random number should be between 1 and 100`() {
        numberGame.generateRandomNumber()
        val generatedNumber = numberGame.getRandomNumber()
        assertTrue("Random number is out of range!", generatedNumber in 1..100)
    }
}