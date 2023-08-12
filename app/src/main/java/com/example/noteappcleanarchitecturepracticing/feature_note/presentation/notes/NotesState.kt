package com.example.noteappcleanarchitecturepracticing.feature_note.presentation.notes

import com.example.noteappcleanarchitecturepracticing.feature_note.domain.model.Note
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.util.NoteOrder
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.util.Priority

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Descending(Priority.High)
)