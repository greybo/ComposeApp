package com.example.composeapp.ui.examples.tutorial

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.ui.examples.messages.MessageCard
import com.example.composeapp.ui.examples.messages.MessageViewModel


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

