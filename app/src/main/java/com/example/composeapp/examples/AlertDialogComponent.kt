package com.example.composeapp.examples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AlertDialogComponentMain() {

    val isShowDialog = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        OutlinedButton(onClick = { isShowDialog.value = true }) {
            Text(text = "Open dialog")
        }

        AlertDialogComponent(isShowDialog.value)

    }

}

@Composable
fun AlertDialogComponent(isShowDialog: Boolean) {
    if (isShowDialog.value) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onCloseRequest.
                isShowDialog.value = false
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
                        isShowDialog.value = false
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        isShowDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            }
        )
    }
}

@Preview
@Composable
fun PreviewAlertDialogComponentMain() {
    AlertDialogComponentMain()
}