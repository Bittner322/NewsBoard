package com.mikhail.newsboard.widgets

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.mikhail.newsboard.theme.NewsTheme
import com.mikhail.newsboard.theme.defaults.NewsTopBarDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsCenterAlignedTopBar(
    text: String,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = text,
                color = NewsTheme.color.black,
                style = NewsTheme.typography.semibold,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = NewsTopBarDefaults.topBarColors()
    )
}