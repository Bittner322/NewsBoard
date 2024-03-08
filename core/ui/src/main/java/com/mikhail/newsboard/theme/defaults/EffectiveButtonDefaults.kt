package com.mikhail.newsboard.theme.defaults

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mikhail.newsboard.theme.NewsTheme

object NewsButtonDefaults {

    @Composable
    fun buttonDefaults(
        enabledContainerColor: Color = NewsTheme.color.primary,
        disabledContainerColor: Color = NewsTheme.color.greySuperLight,
        contentColor: Color = Color.White
    ): ButtonColors {
        return ButtonDefaults.buttonColors(
            containerColor = enabledContainerColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = contentColor,
            contentColor = contentColor
        )
    }
}