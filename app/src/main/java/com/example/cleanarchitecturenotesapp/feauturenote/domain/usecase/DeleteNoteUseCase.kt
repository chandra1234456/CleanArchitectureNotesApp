package com.example.cleanarchitecturenotesapp.feauturenote.domain.usecase

import com.example.cleanarchitecturenotesapp.feauturenote.domain.model.Note
import com.example.cleanarchitecturenotesapp.feauturenote.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}