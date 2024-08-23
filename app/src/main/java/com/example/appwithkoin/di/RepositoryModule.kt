package com.example.appwithkoin.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.appwithkoin.feature.authscreen.data.repository.AuthRepository
import com.example.appwithkoin.feature.authscreen.data.repository.AuthRepositoryImp
import com.example.appwithkoin.feature.homescreen.data.repository.ProductRepository
import com.example.appwithkoin.feature.homescreen.data.repository.ProductRepositoryImp
import com.example.appwithkoin.feature.note.data.repository.LocalNoteRepositoryImp
import com.example.appwithkoin.feature.note.data.repository.NoteRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "note_preferences")

val repositoryModule = module{
    single { androidContext().dataStore }
    factory <ProductRepository> { ProductRepositoryImp(get()) }
    factory <AuthRepository> { AuthRepositoryImp(get()) }
    factory <NoteRepository> { LocalNoteRepositoryImp(get()) }
}