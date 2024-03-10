package com.mikhail.newsboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.content.ContextCompat
import com.arkivanov.decompose.defaultComponentContext
import com.mikhail.newsboard.root.component.DefaultRootComponent
import com.mikhail.newsboard.root.ui.RootContent
import com.mikhail.newsboard.theme.NewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val root = DefaultRootComponent(componentContext = defaultComponentContext())

        setContent {
            this.window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)
            this.window.navigationBarColor = ContextCompat.getColor(this, R.color.statusBarColor)

            NewsTheme {
                RootContent(component = root)
            }
        }
    }
}
