package ru.jonfir.timer.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.jonfir.timer.di.DIContainer
import ru.jonfir.timer.ui.screens.activities.ActivitiesScreen
import ru.jonfir.timer.ui.screens.activities.categories.ActivityCategoriesScreen
import ru.jonfir.timer.ui.screens.activities.categories.ActivityCategoriesViewModel

object ScreenNames {
    const val ACTIVITIES = "activities"
    const val ACTIVITY_CATEGORIES = "activity_categories"
}

class Navigator(
    private val navController: NavHostController
) {
    fun showActivityCategories() {
        navController.navigate(ScreenNames.ACTIVITY_CATEGORIES) {
            launchSingleTop = true
        }
    }
}

@Composable
fun MyAppNavHost(
    diContainer: DIContainer,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ScreenNames.ACTIVITIES
) {
    val navigator = Navigator(navController)
    NavHost(
        modifier = modifier, navController = navController, startDestination = startDestination
    ) {
        composable(ScreenNames.ACTIVITIES) {
            ActivitiesScreen(navigator)
        }
        composable(ScreenNames.ACTIVITY_CATEGORIES) {
            val vm: ActivityCategoriesViewModel = viewModel(
                factory = ActivityCategoriesViewModel.provideFactory(diContainer.activityCategoriesRepository)
            )
            ActivityCategoriesScreen(vm)
        }
    }
}