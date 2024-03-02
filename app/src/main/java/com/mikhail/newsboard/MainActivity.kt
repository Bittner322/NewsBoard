package com.mikhail.newsboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mikhail.newsboard.theme.NewsBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsBoardTheme {
                // A surface container using the 'background' color from the theme

                var backgroundScreen by remember {
                    mutableStateOf(Color.Blue)
                }
                val colorGenerator: ColorGenerator = remember {
                    ColorGeneratorImpl()
                }
                OnboardingScreen(
                    color = backgroundScreen,
                    onClick = {
                        backgroundScreen = colorGenerator.onClick(backgroundScreen)
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    NewsBoardTheme {
        Greeting("Android")
    }
}
