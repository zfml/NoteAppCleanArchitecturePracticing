package com.example.noteappcleanarchitecturepracticing.feature_note.presentation.addEditNote

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteappcleanarchitecturepracticing.R
import com.example.noteappcleanarchitecturepracticing.feature_note.presentation.addEditNote.components.AddEditNoteContent
import com.example.noteappcleanarchitecturepracticing.feature_note.presentation.navigation.NavigationDestination

object AddEditNoteScreenDestination: NavigationDestination {
    override val route: String = "AddEditNoteScreen"
    override val titleRes: Int
        get() = TODO("Not yet implemented")
    const val noteIdArg = "noteId"
    val routArg = "$route/${noteIdArg}"

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditNoteScreen(
    viewModel: AddEditNoteViewModel = hiltViewModel(),
) {

    val state = viewModel.state.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.saveNote()
            }) {
                Icon(
                     painter = painterResource(id = R.drawable.baseline_save_24),
                    contentDescription = "Save Note"
                )
            }
        },
        content = {innerPadding ->
            AddEditNoteContent(
                modifier = Modifier.padding(innerPadding),
                note = state.value.noteDetail,
                onValueChange = viewModel::updateNoteDetailState
            )
        }
    )
}
