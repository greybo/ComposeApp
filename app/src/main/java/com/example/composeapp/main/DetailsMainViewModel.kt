package com.example.composeapp.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsMainViewModel : ViewModel() {

//    var router: NavHostController? = null
    private val _state = MutableLiveData<List<MainRouterType>>()
    val state: LiveData<List<MainRouterType>> = _state

    init {
        _state.value = MainRouterType.values().toList()
    }

//    fun handleOnClickItem(item: MainComposeItems) {
//        when (item) {
//            MainComposeItems.Color ->  router?.navigate(RouterScreenType.Color.name)
//            else -> TODO()
//        }
//    }
}

