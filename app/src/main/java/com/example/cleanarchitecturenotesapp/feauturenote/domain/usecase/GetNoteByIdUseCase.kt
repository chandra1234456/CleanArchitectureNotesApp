package com.example.cleanarchitecturenotesapp.feauturenote.domain.usecase

import com.example.cleanarchitecturenotesapp.feauturenote.domain.model.Note
import com.example.cleanarchitecturenotesapp.feauturenote.domain.repository.NoteRepository

class GetNoteByIdUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}