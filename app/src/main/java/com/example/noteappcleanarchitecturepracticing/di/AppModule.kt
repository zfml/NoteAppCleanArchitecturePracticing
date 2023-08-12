package com.example.noteappcleanarchitecturepracticing.di

import android.app.Application
import androidx.room.Room
import com.example.noteappcleanarchitecturepracticing.feature_note.data.data_source.NoteDatabase
import com.example.noteappcleanarchitecturepracticing.feature_note.data.repository.NoteRepositoryImpl
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.repository.NoteRepository
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.use_case.AddNoteUseCase
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.use_case.DeleteNoteUseCase
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.use_case.GetAllNotesUseCase
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.NOTE_DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Singleton
    @Provides
    fun provideNoteUseCase(noteRepository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getAllNotesUseCase = GetAllNotesUseCase(noteRepository),
            addNoteUseCase = AddNoteUseCase(noteRepository),
            deleteNoteUseCase = DeleteNoteUseCase(noteRepository)
        )
    }



}