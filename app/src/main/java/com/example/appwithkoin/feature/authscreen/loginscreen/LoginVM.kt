package com.example.appwithkoin.feature.authscreen.loginscreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginVM ():ViewModel(){
    private  val  _state = MutableStateFlow(LoginContract.State())
    val state  = _state.asStateFlow()

    private val _navigationEvent = MutableSharedFlow<LoginContract.LoginEvent>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    fun gotoHome() {
        _state.value = LoginContract.State(loading = true)
        viewModelScope.launch {
            _navigationEvent.emit(LoginContract.LoginEvent.HomeRoute)
        }
    }
}