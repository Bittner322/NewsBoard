package com.mikhail.newsboard.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.mikhail.newsboard.theme.defaults.NewsTextFieldDefaults

@Composable
fun NewsOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    singleLine: Boolean = false,
    charsLimit: Int = Int.MAX_VALUE,
    placeholder: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = {
            if (it.length <= charsLimit) {
                onValueChange(it)
            }
        },
        singleLine = singleLine,
        placeholder = placeholder,
        shape = RoundedCornerShape(12.dp),
        colors = NewsTextFieldDefaults.textFieldColors(),
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation
    )
}