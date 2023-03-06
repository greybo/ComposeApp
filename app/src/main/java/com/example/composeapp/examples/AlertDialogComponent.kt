package com.example.composeapp.examples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AlertDialogComponentMain() {

    val isShowDialog = remember { mutableStateOf(true) }

    if (isShowDialog.value) {
        AlertDialogComponent(isShowDialog)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        OutlinedButton(onClick = { isShowDialog.value = true }) {
            Text(text = "Open dialog")
        }
    }

}

@Composable
fun AlertDialogComponent(openDialog: MutableState<Boolean>) {

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onCloseRequest.
                openDialog.value = false
            },
            title = {
                Text(text = "Title")
            },
            text = {
                Text(
                    "This area typically contains the supportive text " +
                            "which presents the details regarding the Dialog's purpose."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            }
        )
    }
}