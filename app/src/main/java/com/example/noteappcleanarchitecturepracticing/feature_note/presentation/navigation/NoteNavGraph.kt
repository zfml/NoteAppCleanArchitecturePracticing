package com.example.noteappcleanarchitecturepracticing.feature_note.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteappcleanarchitecturepracticing.feature_note.presentation.addEditNote.AddEditNoteScreen
import com.example.noteappcleanarchitecturepracticing.feature_note.presentation.addEditNote.AddEditNoteScreenDestination
import com.example.noteappcleanarchitecturepracticing.feature_note.presentation.notes.NoteScreen
import com.example.noteappcleanarchitecturepracticing.feature_note.presentation.notes.NotesScreenDestination

@Composable
fun NoteHostGraph(
    navHostController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navHostController,
        startDestination = NotesScreenDestination.route
    ) {
         composable(route = NotesScreenDestination.route) {
             NoteScreen(
                 navController = navHostController
             )
         }

        composable(
            route = AddEditNoteScreenDestination.routArg,
            arguments = listOf(
                navArgument(name = AddEditNoteScreenDestination.noteIdArg) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            AddEditNoteScreen()
        }

    }
}