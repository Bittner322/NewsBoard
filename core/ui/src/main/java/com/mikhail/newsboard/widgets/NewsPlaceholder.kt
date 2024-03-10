package com.mikhail.newsboard.widgets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.mikhail.newsboard.theme.NewsTheme

@Composable
fun NewsPlaceholder(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        color = NewsTheme.color.grey,
        style = NewsTheme.typography.medium,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}