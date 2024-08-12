package com.example.appwithkoin.feature.notification

class NotificationContract {
    sealed interface NotificationEvent{
        data object HomeRoute:NotificationEvent
        data object SignUp:NotificationEvent
    }
    data class State(
        val loading:Boolean = false
    )
}