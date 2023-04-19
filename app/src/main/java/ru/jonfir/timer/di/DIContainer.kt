package ru.jonfir.timer.di

import ru.jonfir.timer.model.activity.categories.ActivityCategoriesRepository

interface DIContainer {
    val activityCategoriesRepository: ActivityCategoriesRepository
}