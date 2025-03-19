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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuessTheNumberTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF1B1B1B))
                ) { innerPadding ->
                    TitleScreen(modifier = Modifier.padding(innerPadding))
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
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1B1B1B))
    ) {
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
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GuessTheNumberTheme {
        TitleScreen()
    }
}