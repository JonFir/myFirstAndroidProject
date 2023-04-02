package ru.jonfir.timer

import android.app.Application
import ru.jonfir.timer.di.DIContainerImpl

class App: Application() {
    val diContainer = DIContainerImpl()
}