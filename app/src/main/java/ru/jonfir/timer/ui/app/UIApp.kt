package ru.jonfir.timer.ui.app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import ru.jonfir.timer.di.DIContainer
import ru.jonfir.timer.di.DIContainerPreview
import ru.jonfir.timer.library.DefaultPreview
import ru.jonfir.timer.ui.navigation.MyAppNavHost

@Composable
fun UIApp(diContainer: DIContainer) {
    MaterialTheme {
        MyAppNavHost()
    }
}

@DefaultPreview
@Composable
fun UIAppPreview() {
    val diContainer = DIContainerPreview()
    UIApp(diContainer)
}