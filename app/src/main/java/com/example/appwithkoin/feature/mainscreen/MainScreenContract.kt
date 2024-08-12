package com.example.appwithkoin.feature.mainscreen


class MainScreenContract {
    sealed interface MainEvent{
        data object HomeRoute:MainEvent
        data object NotificationRoute:MainEvent
        data object OrderRoute:MainEvent
    }
    data class State(
        val loading:Boolean = false
    )
}