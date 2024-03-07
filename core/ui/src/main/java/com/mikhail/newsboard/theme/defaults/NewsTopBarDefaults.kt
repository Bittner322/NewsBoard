package com.mikhail.newsboard.theme.defaults

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mikhail.newsboard.theme.NewsTheme

object NewsTopBarDefaults {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun topBarColors(
        containerColor: Color = NewsTheme.color.white
    ): TopAppBarColors {
        return TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor
        )
    }
}