package com.mikhail.newsboard.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikhail.newsboard.theme.NewsTheme

@Composable
fun NewsTopBarWithUnderText(
    topbarText: String,
    underText: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 20.dp)
    ) {
        NewsCenterAlignedTopBar(text = topbarText)

        Text(
            text = underText,
            style = NewsTheme.typography.regular,
            fontSize = 16.sp,
            color = NewsTheme.color.grey,
            textAlign = TextAlign.Start,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}