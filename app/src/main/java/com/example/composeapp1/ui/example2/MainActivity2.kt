package com.example.composeapp1.ui.example2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp1.ui.theme.ComposeApp1Theme


class MainActivity2 : ComponentActivity() {
    private val viewModel by viewModels<MainActivity2ViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: MainActivity2ViewModel) {

    val count = viewModel.countLiveData.observeAsState(0).value
    Column(
        modifier = Modifier.padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {

            Text(text = "Count = $count", textAlign = TextAlign.Center)
        }
        Row(modifier = Modifier.padding(top = 16.dp)) {
            Button(onClick = { viewModel.calculateCount(-1) }, enabled = count > 0) {
                Text(text = "-")
            }
            Button(onClick = { viewModel.calculateCount(1) }, enabled = true) {
                Text(text = "+")
            }
        }
//        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApp1Theme {
//        Greeting(/*viewModel:MainActivityViewModel*/)
    }
}