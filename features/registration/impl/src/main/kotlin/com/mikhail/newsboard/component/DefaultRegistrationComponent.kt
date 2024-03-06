package com.mikhail.newsboard.component

import com.arkivanov.decompose.ComponentContext
import com.mikhail.newsboard.RegistrationComponent

class DefaultRegistrationComponent(
    componentContext: ComponentContext
): RegistrationComponent, ComponentContext by componentContext {

}