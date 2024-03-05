package com.mikhail.newsboard.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class NewsColors(
    val primary: Color,
    val primaryDark: Color,
    val primaryLight: Color,
    val primarySuperLight: Color,
    val black: Color,
    val blackDark: Color,
    val blackLight: Color,
    val blackSuperLight: Color,
    val grey: Color,
    val greyDark: Color,
    val greyLight: Color,
    val greySuperLight: Color,
    val white: Color
)

@Composable
fun ProvideNewsColors(): NewsColors = NewsColors(
    primary = Color(0xFF475AD7),
    primaryDark = Color(0xFF2536A7),
    primaryLight = Color(0xFF8A96E5),
    primarySuperLight = Color(0xFFEEF0FB),
    black = Color(0xFF333647),
    blackDark = Color(0xFF22242F),
    blackLight = Color(0xFF44485F),
    blackSuperLight = Color(0xFF555A77),
    grey = Color(0xFF7C82A1),
    greyDark = Color(0xFF666C8E),
    greyLight = Color(0xFFACAFC3),
    greySuperLight = Color(0xFFF3F4F6),
    white = Color.White
)

val LocalNewsColors = staticCompositionLocalOf<NewsColors> {
    error { "LocalNewsColors not provided" }
}