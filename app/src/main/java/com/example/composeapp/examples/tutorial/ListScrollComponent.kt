package com.example.composeapp.examples.tutorial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapp.components.ButtonOutline

@Composable
fun ListScrollComponent() {

    val counterState = remember { mutableStateOf(0) }
    val namesList = remember { mutableStateOf(listOf("Android", "there")) }
    val scrollState = rememberScrollState()
    val color = if (counterState.value > 5)
        Color.Green else Color.White

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(scrollState)
    ) {
        Column(/*modifier = Modifier.weight(1f)*/) {
            for (name in namesList.value) {
                Text(text = name)
                Divider(color = Color.Black)
            }
        }

        ButtonOutline(textButton = "I've been clicked ${counterState.value} times", containerColor = color) {
            counterState.value++
        }
    }
}

@Preview()
@Composable
fun PreviewMyScreenContent() {
    ListScrollComponent()
}