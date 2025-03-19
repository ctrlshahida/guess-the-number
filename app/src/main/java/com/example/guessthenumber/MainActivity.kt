package com.example.guessthenumber

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput = findViewById<EditText>(R.id.userInput)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        submitButton.setOnClickListener {
            val userNumber = userInput.text.toString().toIntOrNull()

            if (userNumber != null) {
                resultText.text = "You entered: $userNumber"
            } else {
                resultText.text = "Please enter a valid number!"
            }
        }
    }
}
