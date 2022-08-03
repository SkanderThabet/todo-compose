package com.example.todo_compose.navigation.destionations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.todo_compose.ui.screens.splash.SplashScreen
import com.example.todo_compose.util.Constants.SPLASH_SCREEN


fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = SPLASH_SCREEN,
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}