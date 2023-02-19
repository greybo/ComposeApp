package com.example.composeapp.ui.component.tutorial.messages


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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

@Composable
fun ListGreeting(viewModel: MessageViewModel = viewModel()) {
    val stateList by viewModel.uiStateList.collectAsState()

    Column {
        ListHandle(stateList) { index ->
             viewModel.changeDataList(index)
        }
    }
}

@Composable
fun ListHandle(itemsList: List<Message>, callback: (Int) -> Unit) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        itemsIndexed(itemsList) { index, item ->
            MessageCard(item, index, callback)

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