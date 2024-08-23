package com.example.appwithkoin.feature.note.creatnote

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.appwithkoin.R
import com.example.appwithkoin.component.bottomsheet.ShowBottomSheet
import com.example.appwithkoin.component.bottomsheet.listColor
import com.example.appwithkoin.core.color.hexToColor
import com.example.appwithkoin.feature.authscreen.component.AuthTextField
import com.example.appwithkoin.feature.note.data.model.CreateNoteModelBody
import com.example.appwithkoin.util.XPadding
import com.example.appwithkoin.util.XTextExtraLarge
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun  CreateNoteScreen(
    createNoteModelBody: CreateNoteModelBody? = null,
    setEffect:(CreateNoteContract.Effect.Nav) -> Unit
){

    val vm :CreateNoteVM = koinViewModel()
    val state = vm.uiState.collectAsState()


    CreateNoteContent(
        vm,
        vm::setEvent,
        state,
        createNoteModelBody = createNoteModelBody
    )

    LaunchedEffect(Unit) {
        Log.d("Message",createNoteModelBody.toString())
        vm.effect.collect{
          when(it){
             is   CreateNoteContract.Effect.Nav -> {setEffect(it)}
          }
        }
    }

    LaunchedEffect(Unit) {
        if(createNoteModelBody != null){
            vm.updateNoteTitleAndDescription(body = createNoteModelBody)
        }
    }
}
@Composable
private  fun CreateNoteTopBar(
    vm: CreateNoteVM,
    event: (CreateNoteContract.Event) -> Unit,
    createNoteModelBody: CreateNoteModelBody? = null,
    state: State<CreateNoteContract.State>,
) {
    fun createNote(){
        if(createNoteModelBody!=null){
            vm.updateNoteByIndex(createNoteModelBody)
        }
        if(createNoteModelBody == null){
            vm.createNote()
        }
    }
    Row(
        modifier = Modifier
            .background(hexToColor(state.value.currentColor))
            .fillMaxWidth()
            .padding(horizontal = XPadding.ExtraLarge),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "",
            modifier = Modifier
                .padding(end = XPadding.Small)
                .clickable {
                    createNote()
                         event(CreateNoteContract.Event.Back)
                }
        )
        XTextExtraLarge(text = "Create Note")
    }
}
@Composable
private  fun CreateNoteContent(
    vm: CreateNoteVM,
    event: (CreateNoteContract.Event) -> Unit,
    state: State<CreateNoteContract.State>,
    createNoteModelBody: CreateNoteModelBody? = null,
) {

    ShowBottomSheet(
        showBottomSheet = state.value.showBottomSheet,
        onDismissRequest = {
        vm.showBottomSheet(false)
        },
        onChangeIndex = {
            vm.changeIndex(it)
        },
        selectIndex = state.value.selectIndex
    )
    Scaffold(
        topBar = {
            CreateNoteTopBar(vm,event,createNoteModelBody,state)
        },
        modifier = Modifier
            .background(hexToColor(state.value.currentColor))
            .statusBarsPadding()
            ,
        bottomBar = {
           Box (
               modifier = Modifier
                   .fillMaxWidth()
                   .navigationBarsPadding()
                   .imePadding()
                   .background(color = hexToColor(state.value.currentColor))
                   .padding(horizontal = XPadding.ExtraLarge),
           ){
               Icon(
                   painter = painterResource(id = R.drawable.baseline_color_lens_24)
                   , contentDescription = "", tint = Color.LightGray,
                   modifier = Modifier
                       .padding(
                       )
                       .clickable {
                           vm.showBottomSheet(true)
                       }
               )
           }
        },
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            CreateNoteBody(vm,event,state,createNoteModelBody)
        }
    }
}
@Composable
private  fun CreateNoteBody(
    vm: CreateNoteVM,
    event: (CreateNoteContract.Event) -> Unit,
    state: State<CreateNoteContract.State>,
    createNoteModelBody: CreateNoteModelBody?
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = hexToColor(state.value.currentColor),
            )
            .padding(horizontal = XPadding.Medium)
    ){
        AuthTextField(
            hintText = "Title",
            modifier = Modifier
                .height(50.dp),
            modifierText = Modifier.focusRequester(focusRequester = focusRequester),
            borderColor = Color.Transparent,
            backGroundColor =  hexToColor(state.value.currentColor),
            newValue =state.value.title ,
            onValueChange = {
                event (CreateNoteContract.Event.TitleChangeEvent(it))
            },
        )
        AuthTextField(
            hintText = "Description",
            backGroundColor =  hexToColor(state.value.currentColor),
            modifier = Modifier.fillMaxHeight(),
            singleLine = false,
            newValue = state.value.description,
            borderColor = Color.Transparent,
            onValueChange = {
                event (CreateNoteContract.Event.DescriptionEvent(it))
            }
        )

    }
}