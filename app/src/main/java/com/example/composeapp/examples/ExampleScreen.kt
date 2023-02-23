package com.example.composeapp.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.examples.elements.FabComponent
import com.example.composeapp.examples.elements.ToolbarAppComponent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldComponent() {

    var expandedState by remember { mutableStateOf(true) }

    Scaffold(
        topBar = { ToolbarAppComponent() },
        floatingActionButton = {
            FabComponent(text = "Favorite", expanded = expandedState) {
                expandedState = !expandedState
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