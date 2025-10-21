package com.example.cleanarchitecturenotesapp.feauturenote.domain.usecase

import com.example.cleanarchitecturenotesapp.feauturenote.domain.model.InvalidNoteException
import com.example.cleanarchitecturenotesapp.feauturenote.domain.model.Note
import com.example.cleanarchitecturenotesapp.feauturenote.domain.repository.NoteRepository
import kotlin.concurrent.thread

class AddNoteUseCase(
    private val noteRepository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){
            throw InvalidNoteException("The Title of note Can't be Empty")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("The content of note Can't be Empty")
        }
        return noteRepository.insetNote(note)
    }
}