package com.example.todo_compose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.todo_compose.navigation.destionations.listComposable
import com.example.todo_compose.navigation.destionations.splashComposable
import com.example.todo_compose.navigation.destionations.taskComposable
import com.example.todo_compose.ui.viewmodels.SharedViewModel
import com.example.todo_compose.util.Constants.SPLASH_SCREEN
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screens = remember(navController) {
        Screens(navHostController = navController)
    }
    AnimatedNavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        splashComposable(navigateToListScreen = screens.splash)
        listComposable(
            navigateToTaskScreen = screens.task,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screens.list,
            sharedViewModel = sharedViewModel
        )
    }

}