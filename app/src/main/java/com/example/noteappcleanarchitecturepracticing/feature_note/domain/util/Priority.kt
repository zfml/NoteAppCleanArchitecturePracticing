package com.example.noteappcleanarchitecturepracticing.feature_note.domain.util

import androidx.compose.ui.graphics.Color
import com.example.noteappcleanarchitecturepracticing.ui.theme.HighPriorityColor
import com.example.noteappcleanarchitecturepracticing.ui.theme.LowPriorityColor
import com.example.noteappcleanarchitecturepracticing.ui.theme.MediumPriorityColor

enum class Priority(val color: Color) {
    Low(LowPriorityColor),
    Medium(MediumPriorityColor),
    High(HighPriorityColor),
    None(Color.DarkGray)
}