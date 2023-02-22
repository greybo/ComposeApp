package com.example.composeapp.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldComponent() {
    Scaffold(
        topBar = { ToolbarAppComponent() },
        floatingActionButton = {
            FabComponent {
                it.callback = { }
                it.text = "Favorite"
                it.icons = Icons.Default.Favorite
                it
            }
        },
        content = {
            val dpTop = it.calculateTopPadding()
            Column(modifier = Modifier.padding(vertical = dpTop)) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    text = "Top Padding: $dpTop ",
                    fontSize = 20.sp,
                )
            }
        })
}

@Preview
@Composable
fun PreviewScaffoldComponent() {
    ScaffoldComponent()
}