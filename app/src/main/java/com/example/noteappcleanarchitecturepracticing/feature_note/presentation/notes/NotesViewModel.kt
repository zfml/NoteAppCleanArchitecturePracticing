package com.example.noteappcleanarchitecturepracticing.feature_note.presentation.notes

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.model.Note
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.use_case.AddNoteUseCase
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.use_case.NoteUseCases
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.util.NoteOrder
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.util.Priority
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCase: NoteUseCases
): ViewModel() {

    private val _notesState = MutableStateFlow(NotesState())
    val notesState: StateFlow<NotesState> =
        noteUseCase.getAllNotesUseCase(NoteOrder.Descending(Priority.None))
            .map {
                NotesState(
                    notes = it
                )
            }.stateIn(
                viewModelScope,
                started = SharingStarted.WhileSubscribed(TIME_OUT_MILLIS),
                initialValue = NotesState()
            )

       companion object{
           const val TIME_OUT_MILLIS = 5000L
       }


    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteUseCase.deleteNoteUseCase(note)
        }
    }

}