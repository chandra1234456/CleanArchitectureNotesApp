package com.example.cleanarchitecturenotesapp.feauturenote.data.repository

import com.example.cleanarchitecturenotesapp.feauturenote.data.datasource.NotesDao
import com.example.cleanarchitecturenotesapp.feauturenote.domain.model.Note
import com.example.cleanarchitecturenotesapp.feauturenote.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val notesDao: NotesDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return notesDao.getNotes()
    }

    override suspend fun insetNote(note: Note) {
        return notesDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return notesDao.deleteNote(note)
    }

    override suspend fun getNoteById(id: Int): Note? {
        return notesDao.getNoteById(id)
    }
}