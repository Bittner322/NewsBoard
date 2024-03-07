package com.mikhail.newsboard.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.mikhail.newsboard.OnboardingComponent
import com.mikhail.newsboard.data.OnboardingPage
import com.mikhail.newsboard.features.onboarding.impl.R
import com.mikhail.newsboard.theme.NewsTheme
import com.mikhail.newsboard.widgets.NewsCenterAlignedTopBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    component: OnboardingComponent,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = NewsTheme.color.white)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NewsCenterAlignedTopBar(
            text = stringResource(R.string.onboarding_topbar_title)
        )

        val pagerState = rememberPagerState(
            pageCount = { OnboardingPage.entries.size }
        )

        HorizontalPager(state = pagerState) { page ->
            Icon(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(OnboardingPage.from(page).resource),
                tint = NewsTheme.color.primary,
                contentDescription = null
            )
        }
    }
}