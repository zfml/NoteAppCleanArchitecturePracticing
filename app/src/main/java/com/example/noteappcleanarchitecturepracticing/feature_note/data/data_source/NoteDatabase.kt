package com.example.noteappcleanarchitecturepracticing.feature_note.data.data_source

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase(){
    abstract val noteDao: NoteDao

    companion object{
        const val NOTE_DATABASE_NAME = "note-practice_db"
    }
}