package com.example.noteappcleanarchitecturepracticing.feature_note.presentation.addEditNote

import com.example.noteappcleanarchitecturepracticing.feature_note.domain.util.Priority

data class NoteUiState(
    val noteDetail: NoteDetail = NoteDetail(),
    val isValid: Boolean = false
)

data class NoteDetail(
    val id: Int = 0,
    val title: String = "",
    val content: String = "",
    val priority: Priority = Priority.Low,
)