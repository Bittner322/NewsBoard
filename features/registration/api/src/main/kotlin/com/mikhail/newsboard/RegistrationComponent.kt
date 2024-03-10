package com.mikhail.newsboard

import com.arkivanov.decompose.value.Value

interface RegistrationComponent {

    val model: Value<Model>

    fun onRegisterClick()
    fun onUsernameChange(username: String)
    fun onEmailChange(email: String)
    fun onPasswordChange(password: String)
    fun onPasswordRepeatChange(passwordRepeat: String)

    data class Model(
        val username: String,
        val email: String,
        val password: String,
        val passwordRepeat: String,
    ) {
        companion object {
            val default = Model(
                username = "",
                email = "",
                password = "",
                passwordRepeat = ""
            )
        }
    }
}