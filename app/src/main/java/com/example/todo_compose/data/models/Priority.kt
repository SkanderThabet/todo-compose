package com.example.todo_compose.data.models

import android.graphics.Color

enum class Priority(val color: Color) {
    HIGHT(),
    MEDUIM(),
    LOW(),
    NONE()
}