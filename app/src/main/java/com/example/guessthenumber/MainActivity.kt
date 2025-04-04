package com.example.guessthenumber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.guessthenumber.ui.theme.GuessTheNumberTheme
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuessTheNumberTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color(0xFF1B1B1B)
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFF1B1B1B))
                            .padding(innerPadding)
                    ) {
                        TitleScreen()
                    }
                }
                }
        }
    }
}

val customFontFamily = FontFamily(
    Font(R.font.magic1)
)

@Composable
fun TitleScreen(modifier: Modifier = Modifier) {
    val game = remember { mutableStateOf(NumberGame()) }
    val userInput = remember { mutableStateOf(TextFieldValue()) }
    val feedback = remember { mutableStateOf("") }

    // Ensure a number is set when the screen is first composed
    LaunchedEffect(Unit) {
        game.value.generateRandomNumber()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))

        Image(
            painter = painterResource(id = R.drawable.randompurple),
            contentDescription = "Mystical Image",
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 10.dp)
        )

        Text(
            text = "Guess The Number!",
            style = TextStyle(
                fontFamily = customFontFamily,
                color = Color(0xFFE6E6FA),
                fontSize = 56.sp,
            ),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Text(
            text = "Pick a number between 1-100.",
            style = TextStyle(
                fontFamily = customFontFamily,
                color = Color(0xFF6A5ACD),
                fontSize = 30.sp
            ),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // TextField for user input
        TextField(
            value = userInput.value,
            onValueChange = { userInput.value = it },
            label = { Text("Enter your number here") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        // Button to submit the guess
        Button(
            onClick = {
                val inputNumber = userInput.value.text.toIntOrNull()
                if (inputNumber != null && inputNumber in 1..100) {
                    val targetNumber = game.value.getRandomNumber()
                    feedback.value = when {
                        inputNumber < targetNumber -> "Too low! Try again."
                        inputNumber > targetNumber -> "Too high! Try again."
                        else -> {
                            game.value.generateRandomNumber() // Reset number on correct guess
                            "Congratulations! You guessed it! New number generated."
                        }
                    }
                } else {
                    feedback.value = "Invalid input! Enter a number between 1 and 100."
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6A5ACD),
                contentColor = Color.White
            ),
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Text(
                text = "Submit Guess",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        // Display feedback
        Text(
            text = feedback.value,
            style = TextStyle(
                fontFamily = customFontFamily,
                color = Color.White,
                fontSize = 24.sp,
            ),
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GuessTheNumberTheme {
        TitleScreen()
    }
}