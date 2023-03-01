package com.example.composeapp.examples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.examples.toolbar.AppBarComponent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenWithScaffold() {

    Scaffold(
        topBar = { AppBarComponent()
        },


        bottomBar = {
            BottomAppBar {
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Избранное"
                    )
                }
                Spacer(Modifier.weight(1f, true))
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "Информация о приложении"
                    )
                }
            }
        }
    ) {

        Box(modifier = Modifier.padding(top = it.calculateTopPadding())) {
            Row(modifier = Modifier.padding(start = 24.dp)) {
                TwoText("Android")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenWithScaffoldPreview() {
    ScreenWithScaffold()
}