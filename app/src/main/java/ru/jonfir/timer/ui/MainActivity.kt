package ru.jonfir.timer.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.jonfir.timer.App
import ru.jonfir.timer.ui.app.UIApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val diContainer = (application as App).diContainer
        setContent {
            UIApp(diContainer)
        }
    }
}