package com.example.composeapp.ui.component.tutorial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyScreenContent(/*names: List<String> = listOf("Android", "there")*/) {

    val counterState = remember { mutableStateOf(0) }
    val namesList = remember { mutableStateOf(listOf("Android", "there")) }

    Column(modifier = Modifier.fillMaxHeight()) {
        Column(/*modifier = Modifier.weight(1f)*/) {
            for (name in namesList.value) {
                Text(text = name)
                Divider(color = Color.Black)
            }
        }
        Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
                val list = namesList.value.toMutableList()
                list.add("count$newCount")
                namesList.value = list
            }
        )
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count + 1) },
        border = BorderStroke(2.dp, Color.Red),
        colors = ButtonDefaults
            .buttonColors(
                containerColor = if (count > 5)
                    Color.Green else Color.White
            )
    ) {
        Text(
            text = "I've been clicked $count times",
            color = Color.Blue
        )
    }
}

@Preview()
@Composable
fun PreviewMyScreenContent() {
    MyScreenContent()
}