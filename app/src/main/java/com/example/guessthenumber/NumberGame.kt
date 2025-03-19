package com.example.guessthenumber
import kotlin.random.Random

class NumberGame {
    private var randomNumber: Int = 0

    fun generateRandomNumber() {
        randomNumber = Random.nextInt(1, 101)
        println("New random number generated.")
    }

    fun getRandomNumber(): Int {
        return randomNumber
    }
}