package com.example.noteappcleanarchitecturepracticing.feature_note.presentation.addEditNote.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.model.Note
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.util.Priority
import com.example.noteappcleanarchitecturepracticing.feature_note.presentation.notes.components.PriorityItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.noteappcleanarchitecturepracticing.feature_note.presentation.addEditNote.NoteDetail
import com.example.noteappcleanarchitecturepracticing.ui.theme.HighPriorityColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditNoteContent(
    modifier: Modifier = Modifier,
    note: NoteDetail,
    onValueChange: (NoteDetail) -> Unit
){
    var expanded by remember{ mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = note.title,
            onValueChange = {
                 onValueChange(note.copy(title = it))
            },
            label = {
                Text(text = "Title")
            }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = note.content,
            onValueChange = {
                  onValueChange(note.copy(content = it))
            },
            label = {
                Text(text = "Content")
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clickable { expanded = true },
            verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
              text = note.priority.name,
              modifier = Modifier.weight(8f)
          )
          PriorityItem(color = HighPriorityColor)
          IconButton(onClick = { expanded = true}) {
              Icon(
                  imageVector = Icons.Default.ArrowDropDown,
                  contentDescription = "Drop Down"
              )

          }
        }
        DropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false},
        ) {
            DropdownMenuItem(
                text = {
                    PriorityItem(color = Priority.High.color)
                },
                onClick = {
                    onValueChange(note.copy(
                        priority = Priority.High
                    ))
                }
            )
            DropdownMenuItem(
                text = {
                    PriorityItem(color = Priority.Medium.color)
                },
                onClick = {
                    onValueChange(note.copy(
                        priority = Priority.Medium
                    ))
                }
            )
            DropdownMenuItem(
                text = {
                    PriorityItem(color = Priority.Low.color)
                },
                onClick = {
                    onValueChange(note.copy(
                        priority = Priority.Low
                    ))
                }
            )
        }

    }

}

@Preview
@Composable
fun AddEditNoteContentPreview() {
    AddEditNoteContent(
        note = NoteDetail(0,"Hello Edit TextField","Edit Textfield",Priority.High),
        onValueChange = {}
    )
}