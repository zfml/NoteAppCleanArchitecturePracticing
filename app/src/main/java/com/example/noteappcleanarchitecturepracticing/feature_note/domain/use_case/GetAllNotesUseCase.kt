package com.example.noteappcleanarchitecturepracticing.feature_note.domain.use_case

import com.example.noteappcleanarchitecturepracticing.feature_note.domain.model.Note
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.repository.NoteRepository
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.util.NoteOrder
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.util.Priority
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllNotesUseCase(
    private val noteRepository: NoteRepository
) {
    operator fun invoke(noteOrder: NoteOrder): Flow<List<Note>> {

        return noteRepository.getAllNotes().map { notes ->
            when(noteOrder) {
                is NoteOrder.Ascending -> {
                    when(noteOrder.priority) {
                        Priority.None -> notes
                        Priority.High -> notes.filter { it.priority.name == Priority.High.name }.sortedBy { it.priority }
                        Priority.Low -> notes.filter { it.priority.name == Priority.Low.name }.sortedBy { it.priority }
                        Priority.Medium -> notes.filter { it.priority.name == Priority.Medium.name }.sortedBy { it.priority }
                    }
                }

                is NoteOrder.Descending -> {
                    when(noteOrder.priority) {
                        Priority.None -> notes
                        Priority.High -> notes.filter { it.priority.name == Priority.High.name }.sortedByDescending { it.priority }
                        Priority.Low -> notes.filter { it.priority.name == Priority.Low.name }.sortedByDescending { it.priority }
                        Priority.Medium -> notes.filter { it.priority.name == Priority.Medium.name }.sortedByDescending { it.priority }

                    }
                }
            }
        }
    }
}