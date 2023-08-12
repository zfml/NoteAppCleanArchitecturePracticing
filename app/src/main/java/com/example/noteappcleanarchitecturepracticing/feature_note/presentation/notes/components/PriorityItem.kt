package com.example.noteappcleanarchitecturepracticing.feature_note.presentation.notes.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteappcleanarchitecturepracticing.feature_note.domain.util.Priority

@Composable
fun PriorityItem (
    modifier: Modifier = Modifier,
    color: Color
) {
    Box(
        modifier = modifier
    ) {
        Canvas(modifier = Modifier.size(25.dp)) {
             drawCircle(
               color = color
             )
        }
    }
}

@Preview
@Composable
fun PriorityPreview() {
    PriorityItem(color = Priority.Low.color)
}
    