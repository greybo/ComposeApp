package com.example.composeapp.examples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapp.components.AlertDialogComponent

@Composable
fun AlertDialogDemo() {

    val isShowDialog = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        OutlinedButton(onClick = { isShowDialog.value = true }) {
            Text(text = "Open dialog")
        }

        AlertDialogComponent(isShowDialog)
    }
}

@Preview
@Composable
fun PreviewAlertDialogDemo() {
    AlertDialogDemo()
}