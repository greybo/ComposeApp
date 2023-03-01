package com.example.composeapp.examples.sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.utils.hideKeyboard
import com.example.composeapp.utils.showKeyboard
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun BottomSheetScaffoldComponent() {
    val roundedCornerRadius = 12.dp
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    val focusRequester1 = remember { FocusRequester() }
    val context = LocalContext.current
//    LaunchedEffect(bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
//
//    }
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(
            topStart = roundedCornerRadius,
            topEnd = roundedCornerRadius
        ),
        sheetContent = {
            Box(
                Modifier
                    .fillMaxHeight(0.5f)
                    .background(Color.Yellow)
//                    .swipeable(
//                        state = state,
//                        anchors = anchors,
//                        thresholds = thresholds,
//                        orientation = Orientation.Horizontal,
//                        enabled = state.currentValue == Default,
//                        reverseDirection = isRtl,
//                        resistance = ResistanceConfig(
//                            basis = width,
//                            factorAtMin = minFactor,
//                            factorAtMax = maxFactor
//                        )
//                    )
//                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .align(Alignment.TopCenter),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    val label1 = "Кількість"
                    val label2 = "Ціна"
                    val text1 = "one"
                    val text2 = "two"
                    var field_1 by remember { mutableStateOf(text1) }
                    var field_2 by remember { mutableStateOf(text2) }

                    OutlinedTextField(
                        value = field_1,
                        singleLine = true,
                        modifier = Modifier
                            .padding(all = 16.dp)
                            .imePadding()
                            .fillMaxWidth(0.3f)
                            .focusRequester(focusRequester1),
                        onValueChange = { field_1 = it },
                        label = { Text(label1) },
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
                        modifier = Modifier
                            .padding(all = 16.dp)
                            .imePadding()
                            .fillMaxWidth(0.5f),
                        onValueChange = { field_2 = it },
                        label = { Text(label2) },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { context.hideKeyboard() }
                        ),
                    )
                }
            }
        },
        sheetPeekHeight = 0.dp//160.dp
    ) {
        Button(onClick = {
            coroutineScope.launch {
                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                    bottomSheetScaffoldState.bottomSheetState.expand()

                    context.showKeyboard()
                    focusRequester1.requestFocus()
                } else {
                    bottomSheetScaffoldState.bottomSheetState.collapse()
                    context.hideKeyboard()
                }
            }
        }) {
            Text(text = "Expand/Collapse Bottom Sheet")
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun PreviewBottomSheetScaffoldComponent() {
    BottomSheetScaffoldComponent()
}