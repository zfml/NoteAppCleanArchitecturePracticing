package com.example.noteappcleanarchitecturepracticing.feature_note.presentation.addEditNote

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.model.Note
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCases: NoteUseCases
): ViewModel() {

    val noteId = checkNotNull(savedStateHandle["noteId"])

    private val _state = MutableStateFlow(NoteUiState())
    val state: StateFlow<NoteUiState> = _state.asStateFlow()

    fun updateNoteDetailState(noteDetail: NoteDetail) {


        Log.d("UpdateState",noteDetail.toString())

        _state.update { currentState ->
            currentState.copy(
                noteDetail = noteDetail
            )
        }
    }

    private fun invalidInput(noteDetail: NoteDetail = _state.value.noteDetail): Boolean{
        return with(noteDetail) {
            title.isNotBlank() && content.isNotBlank()
        }

    }
    fun saveNote() {
        if(invalidInput()) {
            viewModelScope.launch {
                useCases.addNoteUseCase(_state.value.noteDetail.toNote())
                Log.d("AddNoteState",_state.value.noteDetail.toNote().toString())
            }
        }
    }


    private fun NoteDetail.toNote() : Note = Note(
        id = id,
        title = title,
        content = content,
        priority = priority

    )



}