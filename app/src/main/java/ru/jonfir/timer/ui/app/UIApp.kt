package ru.jonfir.timer.ui.app

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.jonfir.timer.di.DIContainer
import ru.jonfir.timer.di.DIContainerPreview
import ru.jonfir.timer.library.DefaultPreview
import ru.jonfir.timer.ui.screens.main.MainScreen

@Composable
fun UIApp(diContainer: DIContainer) {
    MaterialTheme {
        MainScreen()
    }
}

@DefaultPreview
@Composable
fun UIAppPreview() {
    val diContainer = DIContainerPreview()
    UIApp(diContainer)
}