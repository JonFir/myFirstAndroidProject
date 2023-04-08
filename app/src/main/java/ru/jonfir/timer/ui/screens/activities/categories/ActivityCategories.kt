package ru.jonfir.timer.ui.screens.activities.categories

import android.annotation.SuppressLint
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import ru.jonfir.timer.library.DefaultPreview
import ru.jonfir.timer.ui.screens.activities.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ActivityCategories(
) {
    Scaffold(
//        topBar = { MainTopAppBar() },
//        bottomBar = {  MainBottomBar() },
//        floatingActionButton = { MainFloatingActionButton(onClick = {
//            mainViewModel.newItem()
//        }) },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ){
//        Column(
//            modifier = Modifier
//                .verticalScroll(rememberScrollState())
//        ) {
//            mainUUState.items.forEach { item ->
//                ActivitiesListItem(item)
//            }
//        }

    }
}

@DefaultPreview
@Composable
fun ActivityCategoriesScreenPreview() {
    ActivityCategories()
}