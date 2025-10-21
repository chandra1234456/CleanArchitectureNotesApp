package com.example.cleanarchitecturenotesapp.feauturenote.domain.repository

import com.example.cleanarchitecturenotesapp.feauturenote.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>
    suspend fun insetNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun getNoteById(id: Int): Note?
}