package ru.jonfir.timer.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.jonfir.timer.ui.screens.activities.ActivitiesScreen
import ru.jonfir.timer.ui.screens.activities.categories.ActivityCategories

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
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ScreenNames.ACTIVITIES
) {
    val navigator = Navigator(navController)
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ScreenNames.ACTIVITIES) {
            ActivitiesScreen(navigator)
        }
        composable(ScreenNames.ACTIVITY_CATEGORIES) {
            ActivityCategories()
        }
    }
}