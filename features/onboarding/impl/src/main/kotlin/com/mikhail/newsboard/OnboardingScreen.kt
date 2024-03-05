package com.mikhail.newsboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mikhail.newsboard.theme.NewsTheme

@Composable
fun OnboardingScreen(
    component: OnboardingComponent,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = NewsTheme.color.primary)
    )
}