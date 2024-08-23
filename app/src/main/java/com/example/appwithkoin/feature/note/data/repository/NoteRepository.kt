package com.example.appwithkoin.feature.note.data.repository
import com.example.appwithkoin.feature.note.data.model.CreateNoteModelBody
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun createNote(body: CreateNoteModelBody)
    suspend fun getListNote():Flow<List<CreateNoteModelBody>>
    suspend fun removeAllNote()
    suspend fun updateNoteUsingId(body: CreateNoteModelBody)
}