package com.example.cleanarchitecturenotesapp.feauturenote.presentation.addeditnote.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturenotesapp.feauturenote.domain.usecase.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCase: NoteUseCase
): ViewModel() {
}