package com.example.todo_compose.navigation.destionations

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todo_compose.util.Action
import com.example.todo_compose.util.Constants
import com.example.todo_compose.util.Constants.TASK_ARGUMENTS_KEY
import com.example.todo_compose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(Constants.TASK_ARGUMENTS_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENTS_KEY)
        Log.d("TaskComposable", taskId.toString())

    }
}