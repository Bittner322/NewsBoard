package com.mikhail.newsboard.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp

@Composable
fun NewsTheme(
    content: @Composable () -> Unit
) {
    val newsColors = ProvideNewsColors()
    val newsTypography = ProvideNewsTypography()

    MaterialTheme {
        CompositionLocalProvider(
            LocalNewsColors provides newsColors,
            LocalNewsTypography provides newsTypography,
            content = content
        )
    }
}

object NewsTheme {
    val color: NewsColors
        @Composable
        get() = LocalNewsColors.current
    val typography: NewsTypography
        @Composable
        get() = LocalNewsTypography.current
}

val bottomNavHeight = 80.dp