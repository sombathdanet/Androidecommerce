package com.example.appwithkoin.feature.note.creatnote
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.appwithkoin.component.bottomsheet.listColor
import com.example.appwithkoin.core.view_model.BaseViewModel
import com.example.appwithkoin.feature.authscreen.loginscreen.LoginContract
import com.example.appwithkoin.feature.note.data.model.CreateNoteModelBody
import com.example.appwithkoin.feature.note.data.repository.NoteRepository
import kotlinx.coroutines.launch
import java.util.UUID


class  CreateNoteVM(
    private  val noteRepository: NoteRepository
): BaseViewModel<CreateNoteContract.State, CreateNoteContract.Event, CreateNoteContract.Effect>(){

    override fun createInitialState() = CreateNoteContract.State()

    override fun handleEvent(event: CreateNoteContract.Event) {
        when(event){
            CreateNoteContract.Event.CreateNoteRoute -> {}
            is CreateNoteContract.Event.DescriptionEvent -> {
                setState { copy(description = event.description) }
            }
            is CreateNoteContract.Event.TitleChangeEvent -> {
                setState { copy(title = event.title) }
            }

            CreateNoteContract.Event.Back -> {setEffect { (CreateNoteContract.Effect.Nav.Back) }}
        }
    }

    fun createNote(){
        viewModelScope.launch {
          if(currentState.title.isNotEmpty() && currentState.description.isNotEmpty()){
              val body = CreateNoteModelBody(
                  id = UUID.randomUUID().toString(),
                  title = currentState.title,
                  description = currentState.description,
                  color = listColor[currentState.selectIndex]
              )
              noteRepository.createNote(body)
          }
        }
    }
    fun  updateNoteTitleAndDescription(body: CreateNoteModelBody){
        setState {
            copy(
                title = body.title,
                description = body.description,
                currentColor = body.color
            )
        }
    }
    fun  updateNoteByIndex(body:CreateNoteModelBody){
        viewModelScope.launch {
            noteRepository.updateNoteUsingId(
                body = CreateNoteModelBody(
                id = body.id,
                title = currentState.title,
                description = currentState.description,
                color = currentState.currentColor
            ))
        }
    }
    fun showBottomSheet( showBottomSheet:Boolean){
        setState { copy(
            showBottomSheet = showBottomSheet
        ) }
    }
    fun  changeIndex(index:Int){
        setState {
            copy(
                selectIndex = index,
                currentColor = listColor[index]
            )
        }
    }
}
