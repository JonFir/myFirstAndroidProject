package ru.jonfir.timer.model.activity.categories

import kotlinx.coroutines.flow.StateFlow

interface ActivityCategoriesRepository {

    val categories: StateFlow<List<ActivityCategory>>

    suspend fun create(name: String)
    suspend fun updateCategories(id: Long, name: String)
    suspend fun deleteCategories(id: Long)

}