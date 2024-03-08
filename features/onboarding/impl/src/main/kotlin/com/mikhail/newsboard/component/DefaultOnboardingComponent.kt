package com.mikhail.newsboard.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import com.arkivanov.decompose.ComponentContext
import com.mikhail.newsboard.OnboardingComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DefaultOnboardingComponent(
    componentContext: ComponentContext,
    private val onNavToRegistrationClick: () -> Unit
): OnboardingComponent, ComponentContext by componentContext {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onNextStepClick(
        pagerState: PagerState,
        coroutineScope: CoroutineScope
    ) {
        val targetPage = if (pagerState.currentPage < pagerState.pageCount - 1) {
            pagerState.currentPage + 1
        } else {
            0
        }
        coroutineScope.launch {
            pagerState.animateScrollToPage(targetPage)
        }
    }

    override fun onGetStartedClick() {
        onNavToRegistrationClick()
    }
}