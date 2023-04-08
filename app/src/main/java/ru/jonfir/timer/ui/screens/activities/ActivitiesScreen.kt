package ru.jonfir.timer.ui.screens.activities

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import ru.jonfir.timer.library.DefaultPreview
import androidx.lifecycle.viewmodel.compose.viewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ActivitiesScreen(
    mainViewModel: ActivitiesScreenViewModel = viewModel()
) {
    val mainUUState by mainViewModel.uiState.collectAsState()
    Scaffold(
        topBar = { MainTopAppBar() },
        bottomBar = {  MainBottomBar() },
        floatingActionButton = { MainFloatingActionButton(onClick = {
            mainViewModel.newItem()
        }) },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ){
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            mainUUState.items.forEach { item ->
                ActivitiesListItem(item)
            }
        }

    }
}

@Composable
private fun MainTopAppBar() {
    TopAppBar { Text("Активности") }
}

@Composable
private fun MainBottomBar() {
    BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 50)
        )
    ){
        IconButton(onClick = { /* Do something */ }) {
            Icon(Icons.Filled.Menu, contentDescription = "Menu")
        }
        IconButton(onClick = { /* Do something */ }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
        }
        Spacer(modifier = Modifier.weight(1f, true))
        IconButton(onClick = { /* Do something */ }) {
            Icon(Icons.Filled.Search, contentDescription = "Search")
        }
        IconButton(onClick = { /* Do something */ }) {
            Icon(Icons.Filled.Settings, contentDescription = "Settings")
        }
    }
}

@Composable
private fun MainFloatingActionButton(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(Icons.Filled.Add,null)
    }
}

@DefaultPreview
@Composable
fun ActivitiesScreenPreview() {
    ActivitiesScreen()
}