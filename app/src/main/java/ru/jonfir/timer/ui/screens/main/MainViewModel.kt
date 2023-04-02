package ru.jonfir.timer.ui.screens.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class MainUIState(
    val items: List<MainListItemConfiguration>,
)

class MainViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        MainUIState(
            items = listOf(
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
        )
    )
    val uiState: StateFlow<MainUIState> = _uiState.asStateFlow()

    fun newItem() {
        _uiState.update {
            it.copy(
                items = it.items.plus(MainListItemConfiguration(
                    Icons.Rounded.Home,
                    "Чтение утренней газеты",
                    "Осознность",
                    "15"
                ))
            )
        }
    }
}

