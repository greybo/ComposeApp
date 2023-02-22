package com.example.composeapp.examples

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class FabCreateModel(
    val backgroundColor: Color = Color.Blue,
    val tint: Color = Color.White,
    val callback: () -> Unit = {}
)

@Composable
fun FabComponent(create: FabCreateModel = FabCreateModel()) {
    FloatingActionButton(
        onClick = { create.callback() },
        containerColor = create.backgroundColor,
        content = {
            Row {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "",
                    tint = create.tint,
                    modifier = Modifier.padding(16.dp, 8.dp, 8.dp, 8.dp)
                )
                Text(
                    text = "Add",
                    color = create.tint,
                    modifier = Modifier
                        .padding(8.dp, 8.dp, 16.dp, 8.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        },
        elevation = FloatingActionButtonDefaults.elevation(10.dp)
    )
}
