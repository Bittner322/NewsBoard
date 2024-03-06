package com.mikhail.newsboard.root.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.mikhail.newsboard.OnboardingComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked(toIndex: Int)

    sealed class Child {
        class Onboarding(val component: OnboardingComponent) : Child()
        /*class BottomNav(val component: BottomNavComponent) : Child()
        class Registration(val component: RegistrationComponent) : Child()*/
    }
}