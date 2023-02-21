package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapp.examples.ToolbarApp
import com.example.composeapp.examples.constraint.SearchResults
import com.example.composeapp.examples.constraint.filters
import com.example.composeapp.examples.constraint.snacks
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column {
        ToolbarApp("Test")
//        Tutorial1Greeting()
//        MessageSingle()
//        MyScreenContent()
//        GameScreen()
//        ListGreeting()
//        ListScrollComponent()
//        ConstraintLayoutContent()
//        DecoupledConstraintLayout()
        SearchResults(snacks, filters, {})
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAppTheme {
        Greeting()
    }
}