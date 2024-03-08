package com.mikhail.newsboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import kotlinx.coroutines.CoroutineScope

interface OnboardingComponent {
    @OptIn(ExperimentalFoundationApi::class)
    fun onNextStepClick(
        pagerState: PagerState,
        coroutineScope: CoroutineScope
    )
    fun onGetStartedClick()
}