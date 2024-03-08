package com.mikhail.newsboard.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikhail.newsboard.theme.NewsTheme
import com.mikhail.newsboard.theme.defaults.NewsButtonDefaults

@Composable
fun NewsSingleLineButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true
) {
    Button(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        enabled = enabled,
        colors = NewsButtonDefaults.buttonDefaults(),
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            style = NewsTheme.typography.semibold,
            text = text,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            fontSize = 16.sp
        )
    }
}