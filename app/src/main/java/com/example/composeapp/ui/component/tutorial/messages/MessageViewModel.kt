package com.example.composeapp.ui.component.tutorial.messages

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*

data class Message(val author: String, val body: String)

class MessageViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(getFakeMessage())
    val uiState: StateFlow<Message> = _uiState.asStateFlow()

    private val _uiStateList = MutableStateFlow(itemsList.toList())
    val uiStateList: StateFlow<List<Message>> = _uiStateList.asStateFlow()

    fun changeData() {
        _uiState.getAndUpdate { model ->
            if (model.author == "author") model.copy(author = "Colleague")
            else if (model.body == "body") model.copy(body = "Hey, take a look at Jetpack Compose, it's great! Hey, take a look at Jetpack Compose, it's great!")
            else model.copy(author = "author", body = "body")
        }
    }

    fun changeDataList(index: Int) {
        _uiStateList.update { state ->
            val list = state.toMutableList()
            val model = list.get(index)
            val changed = if (model.author == "author") model.copy(author = "Colleague")
            else if (model.body == "body") model.copy(body = "Hey, take a look at Jetpack Compose, it's great!  Hey, take a look at Jetpack Compose, it's great!")
            else model.copy(author = "author", body = "body")
            list[index] = changed
            list
        }
    }

}

fun getFakeMessage() = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")



val itemsList = mutableListOf(
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
    Message("author", "body"),
    Message("author", "body"),
    Message("author", "body"),
    Message("author", "body"),
    Message("author", "body"),
    Message("author", "body"),
    Message("author", "body"),
    Message("author", "body"),
    Message("author", "body"),
    Message("author", "body"),
    Message("author", "body"),
)