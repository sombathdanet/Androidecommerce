package com.example.appwithkoin.feature.authscreen.signupscreen

import com.example.appwithkoin.core.view_model.UiEffect
import com.example.appwithkoin.core.view_model.UiEvent
import com.example.appwithkoin.core.view_model.UiState

class  SignUpContract{
    sealed interface SignupEvent:UiEvent{
        data object Back:SignupEvent
        data class FirstNameChangeEvent(val firstname: String):SignupEvent
        data class LastChangeEvent(val lastname: String):SignupEvent
        data class EmailChangeEvent(val email: String):SignupEvent
        data class PasswordChangeEvent(val password: String):SignupEvent
        data class PhoneChangeEvent(val phone: String):SignupEvent
    }
    data class State(
        val loading:Boolean = false,
        val isError:Boolean = false,
        val message:String? = null,
        val fistName:String = "",
        val firstNameError:String?= null,
        val lastName:String = "",
        val lastNameError:String? = null,
        val email:String = "alpha15@gmail.com",
        val emailError: String? = null,
        val password:String = "P@ssword168",
        val passwordError:String? = null,
        val phone:String = "",
        val phoneError:String? = null
    ) :UiState
    sealed interface Effect:UiEffect{
        sealed interface Nav:Effect{
            data object Back:Nav,Effect
        }
    }
}