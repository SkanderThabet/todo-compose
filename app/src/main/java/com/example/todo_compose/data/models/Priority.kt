package com.example.todo_compose.data.models

import androidx.compose.ui.graphics.Color
import com.example.todo_compose.ui.theme.HighPriorityColor
import com.example.todo_compose.ui.theme.LowPriorityColor
import com.example.todo_compose.ui.theme.MediumPriorityColor
import com.example.todo_compose.ui.theme.NonePriorityColor


enum class Priority(val color: Color) {
    HIGHT(HighPriorityColor),
    MEDUIM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}