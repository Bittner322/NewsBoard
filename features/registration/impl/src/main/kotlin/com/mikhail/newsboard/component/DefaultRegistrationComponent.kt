package com.mikhail.newsboard.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.mikhail.newsboard.RegistrationComponent

class DefaultRegistrationComponent(
    componentContext: ComponentContext,
    private val onRegister: () -> Unit
): RegistrationComponent, ComponentContext by componentContext {

    private val state = MutableValue(RegistrationComponent.Model.default)
    override val model: Value<RegistrationComponent.Model> = state

    override fun onRegisterClick() {
        onRegister()
    }

    override fun onUsernameChange(username: String) {
        state.update {
            it.copy(username = username)
        }
    }

    override fun onEmailChange(email: String) {
        state.update {
            it.copy(email = email)
        }
    }

    override fun onPasswordChange(password: String) {
        state.update {
            it.copy(password = password)
        }
    }

    override fun onPasswordRepeatChange(passwordRepeat: String) {
        state.update {
            it.copy(passwordRepeat = passwordRepeat)
        }
    }
}