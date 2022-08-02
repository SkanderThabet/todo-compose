package com.example.todo_compose.data

import androidx.room.*
import com.example.todo_compose.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    //this function will read all tasks from the db using Flow async stream
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM TODO_TABLE WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    /**
     * Insert function will be suspended because it'll run inside the couroutine
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()

    /**
     * Custom Queries for searching and sorting via priority
     */
    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery or description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'M%' THEN 1 WHEN priority LIKE 'H%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByMediumPriority(): Flow<List<ToDoTask>>

}