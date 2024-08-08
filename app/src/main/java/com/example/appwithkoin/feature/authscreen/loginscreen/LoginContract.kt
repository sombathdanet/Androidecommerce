package com.example.appwithkoin.feature.authscreen.loginscreen


class LoginContract {
    sealed interface LoginEvent{
        data object HomeRoute:LoginEvent
        data object SignUp:LoginEvent
    }
    data class State(
        val loading:Boolean = false
    )
}