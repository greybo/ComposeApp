package com.example.composeapp.ui.component.tutorial.example1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate

data class Message(val author: String, val body: String)

class MessageViewModel : ViewModel() {

    val itemsList = arrayListOf<Message>(
        Message(
            "author",
            "Hey, take a look at Jetpack Compose, it's great! Hey, take a look at Jetpack Compose, it's great!"
        ),
        Message(
            "author",
            "Congratulations, you’ve finished the Compose tutorial! You’ve built a simple chat screen efficiently showing a list of expandable & animated messages containing an image and texts, designed using Material Design principles with a dark theme included and previews—all in under 100 lines of code!"
        ),
        Message("author", "body"),
        Message("author", "body"),
        Message("author", "body"),
        Message("author", "body"),
        Message("author", "body"),
    )

    private val _uiState = MutableStateFlow(getFakeMessage())
    val uiState: StateFlow<Message> = _uiState.asStateFlow()

    private val _uiStateList = MutableStateFlow(itemsList)
    val uiStateList: StateFlow<List<Message>> = _uiStateList.asStateFlow()

    fun changeData() {
        _uiState.getAndUpdate { model ->
            if (model.author == "author") model.copy(author = "Colleague")
            else if (model.body == "body") model.copy(body = "Hey, take a look at Jetpack Compose, it's great!")
            else model.copy(author = "author", body = "body")
        }
    }

    fun changeDataList(model: Message, index: Int) {
        _uiStateList.getAndUpdate { list ->
            val changed = if (model.author == "author") model.copy(author = "Colleague")
            else if (model.body == "body") model.copy(body = "Hey, take a look at Jetpack Compose, it's great!")
            else model.copy(author = "author", body = "body")
            list[index] = changed
            list
        }
    }
}

fun getFakeMessage() = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
