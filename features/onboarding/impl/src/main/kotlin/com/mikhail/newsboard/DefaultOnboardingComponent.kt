package com.mikhail.newsboard

import com.arkivanov.decompose.ComponentContext

class DefaultOnboardingComponent(
    componentContext: ComponentContext
): OnboardingComponent, ComponentContext by componentContext {
}