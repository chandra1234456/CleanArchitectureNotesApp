package com.example.cleanarchitecturenotesapp.feauturenote.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecturenotesapp.feauturenote.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase(){
    abstract val notesDao : NotesDao
         companion object{
             const val DATA_BASE_NAME= "Note"
         }
}