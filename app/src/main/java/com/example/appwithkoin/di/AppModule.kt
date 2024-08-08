package com.example.appwithkoin.di
import com.example.appwithkoin.feature.homescreen.HomeScreenViewModel
import com.example.appwithkoin.feature.authscreen.loginscreen.LoginVM
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeScreenViewModel(get()) }
    viewModel { LoginVM() }
}