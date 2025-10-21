package com.example.cleanarchitecturenotesapp.feauturenote.presentation.addeditnote

data class NoteTextFieldState(
    val text: String = "",
    val hit: String = "",
    val isHintVisible: Boolean = false
)