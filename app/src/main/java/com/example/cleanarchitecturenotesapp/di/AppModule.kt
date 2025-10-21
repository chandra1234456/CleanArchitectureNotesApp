package com.example.cleanarchitecturenotesapp.di

import android.app.Application
import androidx.room.Room
import com.example.cleanarchitecturenotesapp.feauturenote.data.datasource.NoteDatabase
import com.example.cleanarchitecturenotesapp.feauturenote.data.repository.NoteRepositoryImpl
import com.example.cleanarchitecturenotesapp.feauturenote.domain.repository.NoteRepository
import com.example.cleanarchitecturenotesapp.feauturenote.domain.usecase.AddNoteUseCase
import com.example.cleanarchitecturenotesapp.feauturenote.domain.usecase.DeleteNoteUseCase
import com.example.cleanarchitecturenotesapp.feauturenote.domain.usecase.GetNotesUseCase
import com.example.cleanarchitecturenotesapp.feauturenote.domain.usecase.NoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDataBase(app: Application): NoteDatabase {
        return Room.databaseBuilder(app, NoteDatabase::class.java, NoteDatabase.DATA_BASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.notesDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCase {
        return NoteUseCase(
            getNoteUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository)
        )

    }

}