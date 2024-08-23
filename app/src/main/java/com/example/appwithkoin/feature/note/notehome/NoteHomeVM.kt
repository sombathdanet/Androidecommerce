package com.example.appwithkoin.feature.note.notehome

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.appwithkoin.core.view_model.BaseViewModel
import com.example.appwithkoin.feature.authscreen.loginscreen.LoginContract
import com.example.appwithkoin.feature.note.data.model.CreateNoteModelBody
import com.example.appwithkoin.feature.note.data.repository.NoteRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class  NoteHomeVM(
    private  val noteRepository: NoteRepository
):BaseViewModel<NoteHomeContract.State,NoteHomeContract.Event,NoteHomeContract.Effect>(){

    override fun createInitialState() = NoteHomeContract.State()

    override fun handleEvent(event: NoteHomeContract.Event) {
        when(event){
            is NoteHomeContract.Event.CreateNoteRoute -> {
                setEffect { NoteHomeContract.Effect.Nav.CreateNoteRoute(event.body) }
            }
        }
    }

    init {
       getNoteList()
    }
    private  fun getNoteList(){
        viewModelScope.launch {
         noteRepository.getListNote().collect{
             setState { copy(listNote = it) }
          }
        }
    }
    fun removeAllNote(){
        viewModelScope.launch {
            noteRepository.removeAllNote()
        }
    }
    fun removeNoteByIndex(body: CreateNoteModelBody){

    }
}
