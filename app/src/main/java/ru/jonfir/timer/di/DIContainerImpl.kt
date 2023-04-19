package ru.jonfir.timer.di

import ru.jonfir.timer.model.activity.categories.ActivityCategoriesInMemoryRepository
import ru.jonfir.timer.model.activity.categories.ActivityCategoriesRepository

class DIContainerImpl: DIContainer {
    override val activityCategoriesRepository: ActivityCategoriesRepository by lazy {
        ActivityCategoriesInMemoryRepository()
    }
}