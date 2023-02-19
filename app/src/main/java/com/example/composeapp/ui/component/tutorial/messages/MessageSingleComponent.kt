package com.example.composeapp.ui.component.tutorial

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.ui.component.tutorial.messages.MessageCard
import com.example.composeapp.ui.component.tutorial.messages.MessageViewModel


@Composable
fun MessageSingle(viewModel: MessageViewModel = viewModel()) {

    val state by viewModel.uiState.collectAsState()

    MessageCard(state,-1) {
        viewModel.changeData()
    }
}

@Preview
@Composable
fun PreviewMessageSingle() {
    MessageSingle()
}

