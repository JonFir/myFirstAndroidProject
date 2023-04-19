package ru.jonfir.timer.ui.screens.activities

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ActivitiesUIState(
    val items: List<ActivitiesItemConfiguration>,
)

class ActivitiesScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        ActivitiesUIState(
            items = listOf(
                ActivitiesItemConfiguration(
                    Icons.Rounded.Home, "Пью чай", "Био", "15"
                ),
                ActivitiesItemConfiguration(
                    Icons.Rounded.Home, "Водные процедуры", "Био", "15"
                ),
                ActivitiesItemConfiguration(
                    Icons.Rounded.Home, "Зарядка", "Спорт", "20"
                ),
                ActivitiesItemConfiguration(
                    Icons.Rounded.Home, "Чтение утренней газеты", "Осознность", "15"
                ),
                ActivitiesItemConfiguration(
                    Icons.Rounded.Home, "Запись видео", "Блогинг", "60"
                ),
            )
        )
    )
    val uiState: StateFlow<ActivitiesUIState> = _uiState.asStateFlow()

    fun newItem() {
        _uiState.update {
            it.copy(
                items = it.items.plus(
                    ActivitiesItemConfiguration(
                        Icons.Rounded.Home, "Чтение утренней газеты", "Осознность", "15"
                    )
                )
            )
        }
    }
}

