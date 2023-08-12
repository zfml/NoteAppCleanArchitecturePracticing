package com.example.noteappcleanarchitecturepracticing.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.util.Priority

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val content: String,
    val priority: Priority
)
{

}