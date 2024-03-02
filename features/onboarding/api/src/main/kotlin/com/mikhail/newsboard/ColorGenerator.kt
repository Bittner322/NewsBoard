package com.mikhail.newsboard

import androidx.compose.ui.graphics.Color

interface ColorGenerator {
    fun onClick(backgroundScreen: Color): Color
}