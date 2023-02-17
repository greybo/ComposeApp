package com.example.composeapp.component

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class CountAddUiState(
    val currentScrambledWord: String = "",
    val currentWordCount: Int = 1,
    val score: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false
)
class CountAddViewModel : ViewModel() {

    // Game UI state
    private val _uiState = MutableStateFlow(CountAddUiState())
    val uiState: StateFlow<CountAddUiState> = _uiState.asStateFlow()

    val countLiveData: MutableLiveData<Int> = MutableLiveData(0)

    fun calculateCount(number: Int) {
        val c = countLiveData.value ?: 0
        countLiveData.value = c + number
    }
}