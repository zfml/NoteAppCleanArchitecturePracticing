package com.example.noteappcleanarchitecturepracticing.feature_note.presentation.notes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.noteappcleanarchitecturepracticing.R
import com.example.noteappcleanarchitecturepracticing.feature_note.presentation.addEditNote.AddEditNoteScreenDestination
import com.example.noteappcleanarchitecturepracticing.feature_note.presentation.navigation.NavigationDestination
import com.example.noteappcleanarchitecturepracticing.feature_note.presentation.notes.components.NoteItem

object NotesScreenDestination: NavigationDestination {
   override val route: String = "NoteList"
   override val titleRes: Int = R.string.title_notes

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
   viewModel: NotesViewModel = hiltViewModel(),
   navController: NavController
) {
   val notesState = viewModel.notesState.collectAsState()
   Scaffold(
      topBar = {
          TopAppBar(
             title = {Text(text = "Your Notes")},
          )
      },
      floatingActionButton = {
         FloatingActionButton(onClick = {
             navController.navigate(AddEditNoteScreenDestination.routArg)
         }) {
            Icon(
               imageVector = Icons.Default.Add,
               contentDescription = stringResource(id = R.string.add_note)
            )
         }
      },
      content = { innerPadding ->
         Column(
            modifier = Modifier
               .fillMaxSize()
               .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
         ){
            if(notesState.value.notes.isEmpty()) {
               Column(
                  modifier = Modifier
                     .fillMaxSize(),
                  verticalArrangement = Arrangement.Center,
                  horizontalAlignment = Alignment.CenterHorizontally
               ){
                  Text(
                     text = "Empty Note",
                     textAlign = TextAlign.Center
                  )
               }

            }
            LazyColumn() {
               items(notesState.value.notes, key = {note -> note.id}) { note ->
                  NoteItem(
                     modifier = Modifier
                        .padding(8.dp)
                        .clickable {

                        }
                     ,
                     note = note,
                     onDeletedClick = {
                        viewModel.deleteNote(note)
                     }
                  )
               }
            }
         }

      }
   )
}
