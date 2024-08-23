package com.example.appwithkoin.core.view_model

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

interface UiState

interface UiEvent

interface UiEffect
abstract  class  BaseViewModel<State: UiState, Event: UiEvent,Effect: UiEffect>():ViewModel(){

    private  val initializerState  :State by lazy { createInitialState() }

    abstract  fun createInitialState():State


    val currentState:State
        get() = uiState.value

    private  val _uiState :MutableStateFlow<State> = MutableStateFlow(initializerState)
    val uiState  = _uiState.asStateFlow()

    private  val _event :MutableSharedFlow<Event> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    private  val _effect : Channel<Effect>  = Channel()
    val effect = _effect.receiveAsFlow()

    fun  setEvent(event:Event){
        val newEvent = event
        viewModelScope.launch { _event.emit(newEvent) }
    }

    protected  fun setState(reduce:State.() -> State){
        val newState = currentState.reduce()
        _uiState.value = newState
    }
    protected  fun  setEffect(builder: () -> Effect){
        val newEffect = builder()
        viewModelScope.launch { _effect.send(newEffect) }
    }

    init {
        subscribeEvents()
    }
    private fun subscribeEvents() {
        viewModelScope.launch {
            event.collect {
                handleEvent(it)
            }
        }
    }
    abstract fun handleEvent(event : Event)
}