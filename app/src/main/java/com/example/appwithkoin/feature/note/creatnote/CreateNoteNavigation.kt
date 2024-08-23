package com.example.appwithkoin.feature.note.creatnote

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.appwithkoin.feature.note.data.model.CreateNoteModelBody


object  CreateNoteDestination{
    const val  CREATE_NOTE_ROUTE  =  "create_note_route"
}
fun NavGraphBuilder.addCreateNoteRoute(
    navController: NavController
)=composable(
    route = CreateNoteDestination.CREATE_NOTE_ROUTE,
    content = {
        val result = navController.previousBackStackEntry?.savedStateHandle?.get<CreateNoteModelBody>("DETAIL_ITEM")
        CreateNoteScreen(
            createNoteModelBody = result,
            setEffect = {
                when(it){
                    CreateNoteContract.Effect.Nav.Back -> {navController.popBackStack()}
                    CreateNoteContract.Effect.Nav.CreateNoteRoute -> {}
                }
            }
        )
    }
)