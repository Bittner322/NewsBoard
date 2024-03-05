package com.mikhail.newsboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import com.mikhail.newsboard.root.DefaultRootComponent
import com.mikhail.newsboard.root.RootContent
import com.mikhail.newsboard.theme.NewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = DefaultRootComponent(componentContext = defaultComponentContext())

        enableEdgeToEdge()
        setContent {
            NewsTheme {
                RootContent(component = root)
            }
        }
    }
}
