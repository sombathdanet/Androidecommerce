package com.example.appwithkoin.feature.note.notehome
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.appwithkoin.core.color.hexToColor
import com.example.appwithkoin.util.ColorApp
import com.example.appwithkoin.util.XPadding
import com.example.appwithkoin.util.XTextExtraLarge
import com.example.appwithkoin.util.XTextMedium
import com.example.appwithkoin.util.XTextSmall
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI


@OptIn(KoinExperimentalAPI::class)
@Composable
fun  NoteHomeScreen(
    setEffect:(effect:NoteHomeContract.Effect.Nav) -> Unit,
){
    val vm : NoteHomeVM = koinViewModel()
    val state = vm.uiState.collectAsState()

    LaunchedEffect(Unit) {
        vm.effect.onEach{
            when(it){
                is NoteHomeContract.Effect.Nav -> {
                    setEffect(it)
                }
            }
        }.collect()
    }
    NoteHomeContent(
        vm,
        vm::setEvent,
        state,
    )
}
@Composable
private  fun NoteScreenTopBar(
    vm: NoteHomeVM,
    setEvent: (NoteHomeContract.Event) -> Unit
){
    Row(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .padding(horizontal = XPadding.ExtraLarge, vertical = XPadding.Small),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        XTextExtraLarge(text = "Note")
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "",
            tint = Color.Red.copy(alpha = 0.7f),
            modifier = Modifier.clickable {
                vm.removeAllNote()
            }
        )
    }
}
@Composable
private fun  NoteHomeContent(
    vm: NoteHomeVM,
    setEvent: (NoteHomeContract.Event) -> Unit,
    state: State<NoteHomeContract.State>
) {
    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            NoteScreenTopBar(
                vm =vm ,
                setEvent = setEvent
            )
        },
        floatingActionButton = {
            FloatingButton(setEvent)
        },
        floatingActionButtonPosition =  FabPosition.End
    ) {
        paddingValues ->  Box (
            modifier = Modifier.padding(paddingValues)
        ){
        NoteHomeScreenBody(
            setEvent,
            state
        )
    }
    }
}
@Composable
private  fun NoteHomeScreenBody(
    setEvent: (NoteHomeContract.Event) -> Unit,
    state: State<NoteHomeContract.State>
){
   if(state.value.listNote.isNotEmpty()){
       LazyColumn (
           modifier = Modifier.padding(horizontal = XPadding.ExtraLarge),
           verticalArrangement = Arrangement.spacedBy(XPadding.Medium)
       ){
           items(state.value.listNote){
               val colorInt = hexToColor(it.color)
               Box (
                   modifier = Modifier
                       .fillMaxWidth()
                       .background(
                           colorInt,
                           shape = RoundedCornerShape(10.dp)
                       )
                       .clickable {
                           setEvent(
                               NoteHomeContract.Event.CreateNoteRoute(
                                   body = it
                               )
                           )
                       }
               ){
                   Column(
                       modifier = Modifier.padding(XPadding.Large)
                   ) {
                       XTextMedium(text =it.title, color = Color.White)
                       XTextSmall(text =it.description,color = Color.White)
                   }
               }
           }
       }
   }
}
@Composable
private  fun FloatingButton(setEvent: (NoteHomeContract.Event) -> Unit) {
    Box(
        modifier = Modifier
            .clip(shape = CircleShape)
            .background(
                color = ColorApp.mainColor
            )
            .padding(XPadding.Medium)
            .clickable {
                setEvent(NoteHomeContract.Event.CreateNoteRoute(null))
            }
    ) {
        Icon(Icons.Rounded.Add, contentDescription = "", tint = Color.White)
    }
}