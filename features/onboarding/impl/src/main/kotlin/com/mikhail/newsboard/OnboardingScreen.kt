package com.mikhail.newsboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun OnboardingScreen(
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .clickable(onClick = onClick)
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