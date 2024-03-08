package com.mikhail.newsboard.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import com.arkivanov.decompose.ComponentContext
import com.mikhail.newsboard.OnboardingComponent
import com.mikhail.newsboard.componentCoroutineScope
import kotlinx.coroutines.launch

class DefaultOnboardingComponent(
    componentContext: ComponentContext
): OnboardingComponent, ComponentContext by componentContext {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onNextStepClick(pagerState: PagerState, page: Int) {
        componentCoroutineScope().launch {
            pagerState.scrollToPage(page)
        }
    }

    override fun onGetStartedClick() {
        TODO("Not yet implemented")
    }
}