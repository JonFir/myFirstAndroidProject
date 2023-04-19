@file:OptIn(ExperimentalMaterial3Api::class)

package ru.jonfir.timer.ui.screens.activities

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.jonfir.timer.library.DefaultPreview
import ru.jonfir.timer.ui.navigation.Navigator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ActivitiesScreen(
    navigator: Navigator? = null,
    mainViewModel: ActivitiesScreenViewModel = viewModel()
) {
    val mainUUState by mainViewModel.uiState.collectAsState()
    Scaffold(topBar = { MainTopAppBar() }, bottomBar = { MainBottomBar() }, floatingActionButton = {
        MainFloatingActionButton(onClick = {
            navigator?.showActivityCategories()
        })
    }, floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            mainUUState.items.forEach { item ->
                ActivitiesListItem(item)
            }
        }

    }
}

@Composable
private fun MainTopAppBar() {
    TopAppBar(title = { Text("Активности") })
}

@Composable
private fun MainBottomBar() {
    BottomAppBar {
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
        Icon(Icons.Filled.Add, null)
    }
}

@DefaultPreview
@Composable
fun ActivitiesScreenPreview() {
    ActivitiesScreen()
}
