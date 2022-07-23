package com.example.todo_compose.ui.screens.task

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todo_compose.R
import com.example.todo_compose.ui.theme.topAppBarBackgroundColor
import com.example.todo_compose.ui.theme.topAppBarContentColor
import com.example.todo_compose.util.Action

@Composable
fun TaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    NewTaskAppBar(navigateToListScreen = navigateToListScreen)
}

@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = stringResource(R.string.add_task),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        }

    )
}

@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(onClick = { onBackClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(R.string.task_back_button_icon),
            tint = MaterialTheme.colors.topAppBarContentColor
        )

    }
}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
) {
    IconButton(onClick = { onAddClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.add_task_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )

    }
}

@Composable
@Preview
fun BackActionPreview() {
    NewTaskAppBar(navigateToListScreen = {})
}