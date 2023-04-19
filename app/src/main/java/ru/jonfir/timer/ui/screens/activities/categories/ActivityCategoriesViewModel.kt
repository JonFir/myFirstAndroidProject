package ru.jonfir.timer.ui.screens.activities.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.jonfir.timer.model.activity.categories.ActivityCategoriesRepository

data class  ActivityCategoriesUIState(
    val items: List<ActivityRowData> = listOf(),
)

class ActivityCategoriesViewModel(private val activityCategoriesRepository: ActivityCategoriesRepository): ViewModel() {
    private val _uiState = MutableStateFlow(ActivityCategoriesUIState())
    val uiState: StateFlow<ActivityCategoriesUIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            activityCategoriesRepository.categories.collect { categories ->
                val items = categories.map { ActivityRowData(title = it.name, action = {}) }
                _uiState.update { oldState ->
                    oldState.copy(items = items)
                }
            }
        }
    }

    fun createActivity(name: String) {
        viewModelScope.launch {
            activityCategoriesRepository.create(name)
        }
    }

    companion object {
        fun provideFactory(
            interestsRepository: ActivityCategoriesRepository,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ActivityCategoriesViewModel(interestsRepository) as T
            }
        }
    }

}