package com.example.composeapp.ui.component.tutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.ui.component.tutorial.example1.Message
import com.example.composeapp.ui.component.tutorial.example1.MessageCard
import com.example.composeapp.ui.component.tutorial.example1.MessageViewModel

@Composable
fun TutorialGreeting(viewModel: MessageViewModel = viewModel()) {
    val itemsList by viewModel.uiState.collectAsState()

    ListHandle(itemsList) {
        viewModel.changeData(it)
    }
}

@Composable
fun ListHandle(itemsList: List<Message>, function: (Message) -> Unit) {

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
fun PreviewTutorialGreeting() {
    TutorialGreeting()
}