package ru.jonfir.timer.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MainListItemConfiguration(
    val icon: ImageVector,
    val title: String,
    val subtitle: String,
    val time: String
)

@Composable
fun MainListItem(
    configuration: MainListItemConfiguration
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 6.dp, horizontal = 12.dp)
        ) {
            Icon(
                configuration.icon,
                contentDescription = "Дом",
                modifier = Modifier.padding(end = 6.dp)
            )
            Column(
                modifier = Modifier.padding(end = 6.dp)
            ) {
                Text(
                    text = configuration.title,
                    fontSize = 15.sp
                )
                Text(
                    text = configuration.subtitle,
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.weight(1f, true))
            Text(
                text = configuration.time,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                style = LocalTextStyle.current.copy(fontFeatureSettings = "tnum"),
            )
        }
        Divider()
    }

}