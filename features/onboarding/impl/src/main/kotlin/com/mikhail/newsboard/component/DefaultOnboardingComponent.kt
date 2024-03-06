package com.mikhail.newsboard.component

import com.arkivanov.decompose.ComponentContext
import com.mikhail.newsboard.OnboardingComponent

class DefaultOnboardingComponent(
    componentContext: ComponentContext
): OnboardingComponent, ComponentContext by componentContext {
    override fun onNextStepClick() {
        TODO("Not yet implemented")
    }

    override fun onGetStartedClick() {
        TODO("Not yet implemented")
    }
}