package com.example.composeapp1.ui.example2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivity2ViewModel : ViewModel() {
    val countLiveData: MutableLiveData<Int> = MutableLiveData(0)

    fun calculateCount(number: Int) {
        val c = countLiveData.value ?: 0
        countLiveData.value = c + number
    }
}