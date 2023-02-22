package com.example.composeapp.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldComponent() {
    Scaffold(
        topBar = { ToolbarAppComponent() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = Color.Red,
                content = {
                    Row {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.padding(16.dp, 8.dp, 8.dp, 8.dp)
                        )
                        Text(
                            text = "Add",
                            color = Color.White,
                            modifier = Modifier
                                .padding(8.dp, 8.dp, 16.dp, 8.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                },
                elevation = FloatingActionButtonDefaults.elevation(10.dp)
            )
        }) {
        val dpTop = it.calculateTopPadding()
        Column(modifier = Modifier.padding(vertical = dpTop)) {
            Text(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 16.dp)
                    .shadow(1.dp, shape = RectangleShape),
                text = "Top Padding: $dpTop ",
                fontSize = 20.sp,
            )
        }
    }

}



@Preview
@Composable
fun PreviewScaffoldComponent() {
    ScaffoldComponent()
}