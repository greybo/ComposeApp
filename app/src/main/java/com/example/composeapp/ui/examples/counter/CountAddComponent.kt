package com.example.composeapp.ui.examples.counter

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.ui.theme.ComposeAppTheme

@Composable
fun Greeting(addViewModel: CountAddViewModel = viewModel()) {

    val count = addViewModel.countLiveData.observeAsState(0).value
    Column(
        modifier = Modifier.padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {

            Text(text = "Count = $count", textAlign = TextAlign.Center)
        }
        Row(modifier = Modifier.padding(top = 16.dp)) {
            Button(onClick = { addViewModel.calculateCount(-1) }, enabled = count > 0) {
                Text(text = "-")
            }
            Button(onClick = { addViewModel.calculateCount(1) }, enabled = true) {
                Text(text = "+")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeAppTheme {
        Greeting()
    }
}
