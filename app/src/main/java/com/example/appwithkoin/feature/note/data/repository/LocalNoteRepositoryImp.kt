package com.example.appwithkoin.feature.note.data.repository

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.appwithkoin.feature.note.data.model.CreateNoteModelBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class LocalNoteRepositoryImp(private val dataStore: DataStore<Preferences>):NoteRepository {

    private companion object {
        val NOTE_KEY = stringPreferencesKey("NOTE_KEY")

    }
    private suspend fun saveListNote(list:List<CreateNoteModelBody>){
        dataStore.edit {
                preferences -> preferences[NOTE_KEY] = Json.encodeToString(list)
        }
    }
    private val getNoteFromLocalStorage:Flow<List<CreateNoteModelBody>> = dataStore.data.map{
        preferences ->
        preferences[NOTE_KEY]?.let { json ->
            Json.decodeFromString<List<CreateNoteModelBody>>(json)
        } ?: emptyList()
    }
    override suspend fun createNote(body:CreateNoteModelBody) {
        val list = getNoteFromLocalStorage.first()
        val newList = list + listOf(body)
        saveListNote(newList)
    }

    override suspend fun getListNote(): Flow<List<CreateNoteModelBody>> {
        return  getNoteFromLocalStorage
    }

    override suspend fun removeAllNote() {
        dataStore.edit {
            it.remove(NOTE_KEY)
        }
    }

    override suspend fun updateNoteUsingId(body: CreateNoteModelBody) {
        val list = getNoteFromLocalStorage.first().toMutableList()
        val index = list.indexOfFirst { it.id == body.id }
        if (index != -1){
            list[index] = body;
            saveListNote(list)
        }
    }


}