package com.mikhail.newsboard.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikhail.newsboard.extensions.runIf
import com.mikhail.newsboard.theme.NewsTheme
import com.mikhail.newsboard.theme.bottomNavHeight

@Composable
fun BaseScreen(
    topbarText: String,
    modifier: Modifier = Modifier,
    underText: String = "",
    isImePaddingApplied: Boolean = false,
    isUnderTextApplied: Boolean = true,
    isBottomNav: Boolean = false,
    isVerticalScrollable: Boolean = false,
    content: @Composable ColumnScope.() -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = NewsTheme.color.white
            )
            .runIf(isBottomNav) {
                padding(bottom = bottomNavHeight)
            }
            .systemBarsPadding()
            .runIf(isImePaddingApplied) {
                imePadding()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (isUnderTextApplied) {
            NewsTopBarWithUnderText(
                topbarText = topbarText,
                underText = underText
            )
        } else {
            NewsCenterAlignedTopBar(text = topbarText)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .runIf(isVerticalScrollable) {
                    verticalScroll(rememberScrollState())
                }
                .padding(
                    top = 16.dp,
                    start = 20.dp,
                    end = 20.dp
                )
        ) {
            content()
        }
    }
}