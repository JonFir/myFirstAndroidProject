package ru.jonfir.timer.model.activity.categories

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.sync.Mutex

class ActivityCategoriesInMemoryRepository : ActivityCategoriesRepository {
    private val mutex = Mutex()
    private val _categories = MutableStateFlow(mockActivities)
    override val categories: StateFlow<List<ActivityCategory>> = _categories.asStateFlow()

    override suspend fun create(name: String) {
        mutex.lock()
        _categories.update { categories ->
            val lastId = categories.maxOfOrNull { it.id } ?: 0
            val newId = lastId + 1
            val newCategory = ActivityCategory(id = newId, name)
            categories + newCategory
        }
        mutex.unlock()
    }

    override suspend fun updateCategories(
        id: Long,
        name: String
    ) {
        mutex.lock()
        val categories = _categories.value.toMutableList()
        val index = categories.indexOfFirst { it.id == id }
        if (index >= 0) {
            categories[index].name = name
        }
        _categories.value = categories
        mutex.unlock()
    }

    override suspend fun deleteCategories(id: Long) {
        mutex.lock()
        _categories.update { categories ->
            categories.filter { it.id != id }
        }
        mutex.unlock()
    }
}

private val mockActivities = listOf(
    ActivityCategory(1, "Био"),
    ActivityCategory(2, "Работа"),
    ActivityCategory(3, "LazyLoad"),
)