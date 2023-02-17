package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composeapp1.ui.theme.ComposeApp1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String) {
    Box {
        Row {
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
        }
        Row {
            Text(text = "Hello $name!")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApp1Theme {
        Greeting("Android")
    }
}