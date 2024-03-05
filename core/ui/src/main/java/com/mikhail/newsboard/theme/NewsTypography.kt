package com.mikhail.newsboard.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class NewsTypography(
    val regular: TextStyle,
    val medium: TextStyle,
    val semibold: TextStyle,
    val bold: TextStyle
)

@Composable
fun ProvideNewsTypography(): NewsTypography = NewsTypography(
    regular = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(400)
    ),
    medium = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(500)
    ),
    semibold = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(600)
    ),
    bold = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(700)
    )
)

val LocalNewsTypography = staticCompositionLocalOf<NewsTypography> {
    error("LocalNewsTypography not initialized")
}