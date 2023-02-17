package com.example.composeapp.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenWithScaffold() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("METANIT.COM", fontSize = 22.sp)
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Filled.Menu,
                            contentDescription = "Меню"
                        )
                    }
                },
                actions = {
                    Spacer(Modifier)
                    IconButton(onClick = {

                    }) {
                        Icon(Icons.Filled.Search, contentDescription = "Поиск")
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors()
                //MaterialTheme.colorScheme.background
            )
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

        Box(modifier = Modifier.padding( it.calculateTopPadding() )) {

//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//
//        }
            twoText("Android")
//            it.calculateTopPadding().div(100.dp)
//            it.calculateRightPadding(LayoutDirection.Ltr).div(100.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenWithScaffoldPreview() {
    ScreenWithScaffold()
}