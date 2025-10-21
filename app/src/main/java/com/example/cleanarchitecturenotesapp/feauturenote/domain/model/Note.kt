package com.example.cleanarchitecturenotesapp.feauturenote.domain.model

import android.os.Message
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cleanarchitecturenotesapp.ui.theme.Pink40
import com.example.cleanarchitecturenotesapp.ui.theme.Pink80
import com.example.cleanarchitecturenotesapp.ui.theme.Purple40
import com.example.cleanarchitecturenotesapp.ui.theme.Purple80
import com.example.cleanarchitecturenotesapp.ui.theme.PurpleGrey40

@Entity
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(Purple80, Purple40, PurpleGrey40, Pink80, Pink40)
    }
}

class InvalidNoteException(message: String) : Exception(message)