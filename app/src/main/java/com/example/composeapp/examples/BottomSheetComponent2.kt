package com.example.composeapp.examples

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.utils.hideKeyboard
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun BottomSheetLayout2() {
    val context = LocalContext.current
    var field_1 by remember { mutableStateOf("field one") }
    var field_2 by remember { mutableStateOf("field two") }


    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = false
    )

    var isSheetFullScreen by remember { mutableStateOf(true) }

    val roundedCornerRadius = if (isSheetFullScreen) 0.dp else 12.dp
    val modifier = if (isSheetFullScreen)
        Modifier.fillMaxSize()
    else
        Modifier.fillMaxWidth()

    BackHandler(modalSheetState.isVisible) {
        coroutineScope.launch { modalSheetState.hide() }
    }


    ModalBottomSheetLayout(
        modifier = Modifier.fillMaxWidth(),
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = roundedCornerRadius, topEnd = roundedCornerRadius),
        sheetContent = {

            Row(
                modifier = modifier
                /* .align(Alignment.CenterHorizontally)*/,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                var field_21 by remember { mutableStateOf("field two") }
                OutlinedTextField(
                    value = field_1,
                    singleLine = true,
//                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { field_1 = it },
                    label = { Text("Field") },
//                        isError = isGuessWrong,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { context.hideKeyboard() }
                    ),
                )

                OutlinedTextField(
                    value = field_2,
                    singleLine = true,
//                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { field_2 = it },
                    label = { Text("Field") },
//                        isError = isGuessWrong,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { context.hideKeyboard() }
                    ),
                )
            }
        },
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = {
                    coroutineScope.launch {
                        if (modalSheetState.isVisible)
                            modalSheetState.hide()
                        else
                            modalSheetState.show()
//                                modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
                    }
                }
            ) {
                Text(text = "Show sheet dialog")
            }
        }

    }
}

@Preview
@Composable
fun PreviewBottomSheetComponent() {
    BottomSheetLayout2()
}