package com.example.composeapp.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarApp(title: String) {
    TopAppBar(
        title = {
            Text(title, fontSize = 22.sp)
        },
        navigationIcon = {
            IconButton(onClick = { }) { Icon(Icons.Filled.Menu, contentDescription = "Меню") }
        },
        actions = {
            Spacer(Modifier)
            IconButton(onClick = {

            }) {
                Icon(Icons.Filled.Search, contentDescription = "Поиск")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(),

        //MaterialTheme.colorScheme.background
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewToolbar() {
    ToolbarApp("META-NIT.COM")
}