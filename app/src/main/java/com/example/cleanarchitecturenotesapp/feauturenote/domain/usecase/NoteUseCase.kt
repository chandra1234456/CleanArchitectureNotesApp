package com.example.cleanarchitecturenotesapp.feauturenote.domain.usecase

import jakarta.inject.Inject

data class NoteUseCase @Inject constructor(
    val getNoteUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNoteUseCase: AddNoteUseCase,
    val getNoteByIdUseCase: GetNoteByIdUseCase
)