package com.example.todo_compose.navigation

import androidx.navigation.NavHostController
import com.example.todo_compose.util.Action
import com.example.todo_compose.util.Constants.LIST_SCREEN

class Screens(navHostController: NavHostController) {
    val list: (Action) -> Unit =
        {
            navHostController.navigate("list/${it.name}") {
                popUpTo(LIST_SCREEN) {
                    inclusive = true
                }
            }
        }
    val task: (Int) -> Unit = {
        navHostController.navigate("task/$it")
    }
}