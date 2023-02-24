package com.example.composeapp.examples

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimationComponent() {
    var editable by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {
        OutlinedButton(onClick = { editable = !editable }) {
            Text(text = "Button")
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {

            Row {
                AnimatedVisibility(visible = editable) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .fillMaxHeight()
                            .background(Color.Gray)
                            .clickable { /*TODO*/ }
                    ) {
                        Text(
                            text = "Exit",
                            modifier = Modifier
                                .padding(top = 32.dp, start = 16.dp)
                                .clickable { editable = !editable }
                        )
                    }
                }
            }
        }

//        Row(
//            modifier = Modifier
//                .fillMaxWidth(0.5f)
//                .fillMaxHeight()
//                .background(Color.Cyan),
//
//            ) {
//            AnimatedVisibility(visible = editable) {
//                Text(text = "Edit",
//                    modifier = Modifier
//                        .fillMaxWidth(0.5f)
//                        .fillMaxHeight()
//                        .background(Color.Cyan),)
//            }
//        }
    }


}