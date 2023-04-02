package ru.jonfir.timer.ui.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.jonfir.timer.library.DefaultPreview

sealed class Screen(val route: String, val hz: String) {
    object Profile : Screen("profile", "1")
    object FriendsList : Screen("friendslist", "2")
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(
        topBar = { MainTopAppBar() },
        bottomBar = {  MainBottomBar() },
        floatingActionButton = { MainFloatingActionButton() },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ){
        val itemsList = listOf(
            MainListItemConfiguration(
                Icons.Rounded.Home,
                "Пью чай",
                "Био",
                "15"
            ),
            MainListItemConfiguration(
                Icons.Rounded.Home,
                "Водные процедуры",
                "Био",
                "15"
            ),
            MainListItemConfiguration(
                Icons.Rounded.Home,
                "Зарядка",
                "Спорт",
                "20"
            ),
            MainListItemConfiguration(
                Icons.Rounded.Home,
                "Чтение утренней газеты",
                "Осознность",
                "15"
            ),
            MainListItemConfiguration(
                Icons.Rounded.Home,
                "Запись видео",
                "Блогинг",
                "60"
            ),
        )
        Column {
            itemsList.forEach { item ->
                MainListItem(item)
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
private fun MainFloatingActionButton() {
    FloatingActionButton(onClick = { /* ... */ }) {
        Icon(Icons.Filled.Add,null)
    }
}

@DefaultPreview
@Composable
fun MainScreenPreview() {
    MainScreen()
}