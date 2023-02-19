package com.example.composeapp.ui.component.tutorial.messages


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ListGreeting(viewModel: MessageViewModel = viewModel()) {
    val stateList by viewModel.uiStateList.collectAsState()
    val itemsList = remember { mutableStateOf(viewModel.itemsList.toList()) }

    Column {

        ListHandle(itemsList.value) { index ->
            itemsList.value = viewModel.changeDataList2(index)
        }
    }
}

@Composable
fun ListHandle(itemsList: List<Message>, function: (Int) -> Unit) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        itemsIndexed(itemsList) { index, item ->
            MessageCard(item, index, function)
//            Text("Item at index $index is $item")

            if (index < itemsList.lastIndex)
                Divider(color = Color.Red, thickness = 1.dp)
        }
    }
}

@Preview()
@Composable
fun PreviewTutorial1Greeting() {
    ListGreeting()
}