package com.example.noteappcleanarchitecturepracticing.feature_note.domain.use_case

import android.util.Log
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.model.Note
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        noteRepository.insertNote(note)
        Log.d("AddNoteState",note.toString())
    }
}