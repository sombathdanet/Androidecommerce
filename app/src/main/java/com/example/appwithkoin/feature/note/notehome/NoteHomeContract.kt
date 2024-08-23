package com.example.appwithkoin.feature.note.notehome

import android.icu.text.CaseMap.Title
import androidx.compose.ui.graphics.Color
import com.example.appwithkoin.core.view_model.UiEffect
import com.example.appwithkoin.core.view_model.UiEvent
import com.example.appwithkoin.core.view_model.UiState
import com.example.appwithkoin.feature.note.data.model.CreateNoteModelBody

class NoteHomeContract {
    sealed class  Event:UiEvent{
        data class CreateNoteRoute(val body:CreateNoteModelBody? = null) :Event()
    }
    data class State(
        val loading:Boolean = false,
        val listNote:List<CreateNoteModelBody> = emptyList()
    ):UiState

    sealed class  Effect:UiEffect{
        sealed class Nav:Effect(){
            data class CreateNoteRoute(val body: CreateNoteModelBody? = null) : Nav()
        }
    }
}