package com.example.appwithkoin.di
import HomeVM
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeVM(get()) }
}