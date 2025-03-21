package com.example.guessthenumber
import kotlin.random.Random

class NumberGame {
    private var randomNumber: Int = Random.nextInt(1, 101)

    fun generateRandomNumber() {
        randomNumber = Random.nextInt(1, 101)
        println("New random number generated.")
    }

    fun getRandomNumber(): Int {
        return randomNumber
    }
}