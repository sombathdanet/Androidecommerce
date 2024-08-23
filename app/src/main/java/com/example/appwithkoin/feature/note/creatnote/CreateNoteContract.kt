package com.example.appwithkoin.feature.note.creatnote

import androidx.compose.ui.graphics.Color
import com.example.appwithkoin.core.view_model.UiEffect
import com.example.appwithkoin.core.view_model.UiEvent
import com.example.appwithkoin.core.view_model.UiState
import okhttp3.internal.tls.TrustRootIndex

class CreateNoteContract {
    sealed interface  Event: UiEvent {
        data object CreateNoteRoute :Event
        data object Back:Event
        data class TitleChangeEvent(val title: String) : Event
        data class DescriptionEvent(val description: String):Event
    }
    data class State(
        val loading:Boolean = false,
        val id:Int = 0,
        val title:String ="",
        val description:String ="",
        val color: Color = Color.Red,
        val showBottomSheet:Boolean = false,
        val selectIndex: Int =0,
        val currentColor:String = "#ffffff"
    ): UiState

    sealed interface  Effect: UiEffect {
        sealed interface Nav:Effect{
            data object  CreateNoteRoute:Nav,Effect
            data object  Back:Nav,Effect
        }
    }
}