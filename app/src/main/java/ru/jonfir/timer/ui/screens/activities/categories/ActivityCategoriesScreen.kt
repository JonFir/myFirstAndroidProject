@file:OptIn(ExperimentalMaterial3Api::class)

package ru.jonfir.timer.ui.screens.activities.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.jonfir.timer.di.DIContainerPreview
import ru.jonfir.timer.library.DefaultPreview
import ru.jonfir.timer.ui.screens.activities.*

@Composable
fun ActivityCategoriesScreen(
    vm: ActivityCategoriesViewModel
) {
    Scaffold(topBar = { MainTopAppBar() }, floatingActionButton = {
        MainFloatingActionButton(onClick = {
            vm.createActivity("asdjnhfjhkhasdjkhfhadjks")
        })
    }, floatingActionButtonPosition = FabPosition.End
    ) { paddings ->
        val state = vm.uiState.collectAsState()
        LazyColumn(
            modifier = Modifier.padding(paddings)
        ) {
            items(state.value.items) { data ->
                ActivityRow(data)
            }
        }

    }
}

data class ActivityRowData(
    val title: String,
    val action: () -> Unit,
)

@Composable
private fun ActivityRow(data: ActivityRowData) {
    ListItem(headlineContent = { Text(text = data.title) }, modifier = Modifier.clickable(onClick = data.action),
             trailingContent = {
                 Icon(
                     Icons.Default.ArrowForward, null
                 )
             })
    Divider(modifier = Modifier.padding(start = 16.dp))
}

@Composable
private fun MainTopAppBar() {
    TopAppBar(title = { Text("Категории активностей") })
}

@Composable
private fun MainFloatingActionButton(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(
            Icons.Filled.Add, null
        )
    }
}

@DefaultPreview
@Composable
fun ActivityCategoriesScreenPreview() {
    val di = DIContainerPreview()
    val vm = ActivityCategoriesViewModel(di.activityCategoriesRepository)
    ActivityCategoriesScreen(vm)
}