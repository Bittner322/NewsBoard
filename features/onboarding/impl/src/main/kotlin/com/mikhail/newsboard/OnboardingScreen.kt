package com.mikhail.newsboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun OnboardingScreen(
    component: OnboardingComponent,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Red)
    )
}

class ColorGeneratorImpl: ColorGenerator {
    override fun onClick(backgroundScreen: Color): Color {
        return if (backgroundScreen == Color.Blue) {
            Color.Red
        } else {
            Color.Blue
        }
    }
}