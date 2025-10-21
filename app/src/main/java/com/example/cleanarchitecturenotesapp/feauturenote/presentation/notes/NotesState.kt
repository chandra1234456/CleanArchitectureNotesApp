package com.example.cleanarchitecturenotesapp.feauturenote.presentation.notes

import com.example.cleanarchitecturenotesapp.feauturenote.domain.model.Note
import com.example.cleanarchitecturenotesapp.feauturenote.domain.util.NoteOrder
import com.example.cleanarchitecturenotesapp.feauturenote.domain.util.OrderType

data class NotesState (
    val notes :List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSelectionVisible : Boolean = false
)

