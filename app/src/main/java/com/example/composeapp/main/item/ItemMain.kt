package com.example.composeapp.main.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.main.MainRouterType

@Composable
fun ItemMainComponent(item: MainRouterType, callback: (MainRouterType) -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { callback(item) }) {
//        TextCrown(
//            text = item.rawValue,
//            style = MaterialTheme.typography.titleLarge,
//            modifier = { padding(start = 16.dp, top = 8.dp, end = 16.dp/*, bottom = 8.dp*/) }
//        )
        Text(
            text = item.rawValue,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewItemMainComponent1() {
    ItemMainComponent(MainRouterType.ToolbarAppComponent, {})
}