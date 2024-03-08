package com.mikhail.newsboard.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mikhail.newsboard.OnboardingComponent
import com.mikhail.newsboard.data.OnboardingPage
import com.mikhail.newsboard.features.onboarding.impl.R
import com.mikhail.newsboard.theme.NewsTheme
import com.mikhail.newsboard.widgets.NewsCenterAlignedTopBar
import com.mikhail.newsboard.widgets.NewsPagerIndicator
import com.mikhail.newsboard.widgets.NewsSingleLineButton

private const val LastPageIndex = 2

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
            val composition by rememberLottieComposition(
                LottieCompositionSpec.RawRes(
                    OnboardingPage.from(page).resource
                )
            )
            val progress by animateLottieCompositionAsState(composition)
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LottieAnimation(
                    composition = composition,
                    progress = { progress },
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(OnboardingPage.from(page).description),
                    style = NewsTheme.typography.semibold,
                    fontSize = 24.sp,
                    color = NewsTheme.color.black
                )
            }
        }

        NewsPagerIndicator(
            dotSize = 8.dp,
            pagerState = pagerState
        )

        Spacer(modifier = Modifier.weight(1f))

        val coroutineScope = rememberCoroutineScope()

        NewsSingleLineButton(
            modifier = Modifier.padding(bottom = 16.dp),
            text = if (pagerState.currentPage == LastPageIndex) {
                stringResource(R.string.onboarding_get_started_button)
            } else {
                stringResource(R.string.onboarding_next_button)
            },
            onClick = {
                if (pagerState.currentPage == LastPageIndex) {
                    component.onGetStartedClick()
                } else {
                    component.onNextStepClick(
                        pagerState = pagerState,
                        coroutineScope = coroutineScope
                    )
                }
            }
        )
    }
}