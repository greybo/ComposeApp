package com.example.composeapp.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.MainActivity
import com.example.composeapp.examples.toolbar.AppBarComponent
import com.example.composeapp.examples.toolbar.homeActionDefault
import com.example.composeapp.main.item.ItemMainComponent

@Composable
fun ComposeDetailsMain(viewModel: DetailsMainViewModel = viewModel(), callback: (MainRouterType) -> Unit) {
    val activity = (LocalContext.current as MainActivity)
    val list = viewModel.state.observeAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        AppBarComponent(homeAction = homeActionDefault(){
            activity.finish()
        })
        Spacer(modifier = Modifier.padding(bottom = 24.dp))

        LazyColumn(content = {
            itemsIndexed(items = list.value ?: emptyList()) { index, item ->
                ItemMainComponent(item, callback)
            }
        })
    }
}

@Preview
@Composable
fun PreviewComposeDetailsMain() {
    ComposeDetailsMain(callback = {})
}
