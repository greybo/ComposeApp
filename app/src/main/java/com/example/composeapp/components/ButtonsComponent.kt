package com.example.composeapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonOutline(textButton: String? = "I've been clicked ${0} times", containerColor: Color, action: () -> Unit) {

    Button(
        onClick = { action() },
        border = BorderStroke(2.dp, Color.Red),
        colors = ButtonDefaults
            .buttonColors(containerColor = containerColor)
    ) {
        textButton?.let {
            Text(
                text = it,
                color = Color.Blue
            )
        }
    }
}