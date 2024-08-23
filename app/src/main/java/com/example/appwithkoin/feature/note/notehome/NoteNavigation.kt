package com.example.appwithkoin.feature.note.notehome

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.appwithkoin.feature.note.creatnote.CreateNoteDestination
import com.example.appwithkoin.feature.note.data.model.CreateNoteModelBody
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

object  NoteDestination{
    const val  NOTE_HOME_ROUTE = "note_home_route"
}
fun NavGraphBuilder.addNoteHomeRoute(
    navController: NavController
) = composable(
    route = NoteDestination.NOTE_HOME_ROUTE,
    content = {
        NoteHomeScreen(
            setEffect = {
                when(it){
                    is NoteHomeContract.Effect.Nav.CreateNoteRoute -> {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            key = "DETAIL_ITEM",
                            value = it.body
                        )
                        navController.navigate(CreateNoteDestination.CREATE_NOTE_ROUTE)
                    }
                }

            }
        )
    }
)