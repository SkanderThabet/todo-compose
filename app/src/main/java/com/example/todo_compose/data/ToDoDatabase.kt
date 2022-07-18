package com.example.todo_compose.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDoDatabase::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}