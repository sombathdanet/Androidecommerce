package com.example.appwithkoin.di
import com.example.appwithkoin.core.device.DeviceInfo
import com.example.appwithkoin.core.device.DeviceInfoModule
import com.example.appwithkoin.feature.homescreen.HomeScreenViewModel
import com.example.appwithkoin.feature.authscreen.loginscreen.LoginVM
import com.example.appwithkoin.feature.authscreen.signupscreen.SignUpVM
import com.example.appwithkoin.feature.note.creatnote.CreateNoteVM
import com.example.appwithkoin.feature.note.notehome.NoteHomeVM
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeScreenViewModel(get()) }
    viewModel { LoginVM(get(),get()) }
    viewModel { SignUpVM(get(),get()) }
    viewModel { NoteHomeVM(get ()) }
    viewModel { CreateNoteVM(get ()) }
}