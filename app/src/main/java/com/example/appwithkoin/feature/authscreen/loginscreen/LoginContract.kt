package com.example.appwithkoin.feature.authscreen.loginscreen

import com.example.appwithkoin.core.view_model.UiEffect
import com.example.appwithkoin.core.view_model.UiEvent
import com.example.appwithkoin.core.view_model.UiState


class LoginContract {
    sealed interface LoginEvent: UiEvent {
        data object HomeRoute:LoginEvent
        data object SignUp:LoginEvent
        data class EmailChange(val email: String) : LoginEvent
        data class PassChange(val pass:String) :LoginEvent
    }
    data class State(
        val loading:Boolean = false,
        val error:Boolean = false,
        var message:String? = null,
        val email:String = "alpha15@gmail.com",
        val errorEmail:String? = null,
        val pass:String = "P@ssword168",
        val errorPass:String? = null
    ): UiState

    sealed interface  Effect: UiEffect {

        sealed interface Nav:Effect{
            data object  HomeRoute:Nav,Effect
            data object  NoteHomeRoute:Nav,Effect
            data object  SignUpRoute:Nav,Effect
        }
    }
}