package com.example.composeapp.ui.component.tutorial

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate

data class Message(val author: String, val body: String)

class MessageViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(Message("author", "body"))
    val uiState: StateFlow<Message> = _uiState.asStateFlow()

    fun changeData() {
        _uiState.getAndUpdate {
            if (it.author == "author") it.copy(author = "Colleague")
            else if (it.body == "body") it.copy(body = "Hey, take a look at Jetpack Compose, it's great!")
            else it.copy(author = "author", body = "body")
        }
    }

    fun getFakeMessage() = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")

}