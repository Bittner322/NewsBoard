package com.mikhail.newsboard.theme.defaults

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mikhail.newsboard.theme.NewsTheme

object NewsTextFieldDefaults {

    @Composable
    fun textFieldColors(
        cursorColor: Color = NewsTheme.color.primary,
        placeholderColor: Color = NewsTheme.color.grey,
        textColor: Color = NewsTheme.color.black,
        unfocusedContainerColor: Color = NewsTheme.color.greySuperLight,
        focusedContainerColor: Color = NewsTheme.color.white,
        unfocusedBorderColor: Color = NewsTheme.color.greySuperLight,
        focusedBorderColor: Color = NewsTheme.color.primary,
        unfocusedLeadingIconColor: Color = NewsTheme.color.grey,
        focusedLeadingIconColor: Color = NewsTheme.color.primary
    ): TextFieldColors {

        return OutlinedTextFieldDefaults.colors(
            cursorColor = cursorColor,
            unfocusedPlaceholderColor = placeholderColor,
            focusedPlaceholderColor = placeholderColor,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            unfocusedContainerColor = unfocusedContainerColor,
            focusedContainerColor = focusedContainerColor,
            unfocusedBorderColor = unfocusedBorderColor,
            focusedBorderColor = focusedBorderColor,
            unfocusedLeadingIconColor = unfocusedLeadingIconColor,
            focusedLeadingIconColor = focusedLeadingIconColor
        )
    }
}