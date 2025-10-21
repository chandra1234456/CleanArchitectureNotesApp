package com.example.cleanarchitecturenotesapp.feauturenote.domain.usecase

data class NoteUseCase(
    val getNoteUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNoteUseCase: AddNoteUseCase
)