package com.example.noteappcleanarchitecturepracticing.feature_note.domain.util

sealed class NoteOrder(priority: Priority){
     data class Descending( val priority: Priority): NoteOrder(priority)
     data class  Ascending( val priority: Priority): NoteOrder(priority)
}