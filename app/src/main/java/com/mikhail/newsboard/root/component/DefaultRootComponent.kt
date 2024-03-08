package com.mikhail.newsboard.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.mikhail.newsboard.OnboardingComponent
import com.mikhail.newsboard.RegistrationComponent
import com.mikhail.newsboard.component.DefaultOnboardingComponent
import com.mikhail.newsboard.component.DefaultRegistrationComponent
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext
): RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.Onboarding,
            serializer = Config.serializer(),
            handleBackButton = true,
            childFactory = ::child
        )

    private fun child(
        config: Config,
        childComponentContext: ComponentContext
    ): RootComponent.Child = when (config) {
        Config.Onboarding -> RootComponent.Child.Onboarding(
            onboardingComponent(
                childComponentContext
            )
        )
        Config.Registration -> RootComponent.Child.Registration(
            registrationComponent(
                childComponentContext
            )
        )
    }

    private fun onboardingComponent(componentContext: ComponentContext): OnboardingComponent =
        DefaultOnboardingComponent(
            componentContext = componentContext,
            onNavToRegistrationClick = {
                navigation.push(
                    Config.Registration
                )
            }
        )

    private fun registrationComponent(componentContext: ComponentContext): RegistrationComponent =
        DefaultRegistrationComponent(componentContext = componentContext)

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Onboarding : Config

        @Serializable
        data object Registration : Config
    }
}