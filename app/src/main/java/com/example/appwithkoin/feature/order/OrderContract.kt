package com.example.appwithkoin.feature.order


class OrderContract {
    sealed interface OrderEvent{
        data object HomeRoute:OrderEvent
        data object SignUp:OrderEvent
    }
    data class State(
        val loading:Boolean = false
    )
}