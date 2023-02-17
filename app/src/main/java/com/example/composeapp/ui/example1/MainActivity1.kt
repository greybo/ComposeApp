package com.example.composeapp.ui.example1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.component.twoText

//
//
class MainActivity1 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text("METANIT.COM", fontSize = 22.sp)
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
                        colors = TopAppBarDefaults.mediumTopAppBarColors()
                        //MaterialTheme.colorScheme.background
                    )
                },


                bottomBar = {
                    BottomAppBar {
                        IconButton(onClick = { }) { Icon(Icons.Filled.Favorite, contentDescription = "Избранное") }
                        Spacer(Modifier.weight(1f, true))
                        IconButton(onClick = { }) { Icon(Icons.Filled.Info, contentDescription = "Информация о приложении") }
                    }
                }
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    twoText("Android")
                }
                it.calculateTopPadding().div(100.dp)
                it.calculateRightPadding(LayoutDirection.Ltr).div(100.dp)
            }
        }
    }

}

@Composable
fun screenWithScaffold(){

}