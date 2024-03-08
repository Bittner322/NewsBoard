package com.mikhail.newsboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState

interface OnboardingComponent {
    @OptIn(ExperimentalFoundationApi::class)
    fun onNextStepClick(
        pagerState: PagerState,
        page: Int
    )
    fun onGetStartedClick()
}