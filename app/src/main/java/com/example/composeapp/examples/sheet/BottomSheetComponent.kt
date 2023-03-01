//package com.example.composeapp.examples.sheet
//
//import android.annotation.SuppressLint
//import androidx.activity.compose.BackHandler
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import kotlinx.coroutines.launch
//
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun BottomSheetLayout() {
//    val coroutineScope = rememberCoroutineScope()
//    val modalSheetState = rememberModalBottomSheetState(
//        initialValue = ModalBottomSheetValue.Hidden,
//        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded },
//        skipHalfExpanded = false
//    )
//
//    var isSheetFullScreen by remember { mutableStateOf(false) }
//    val roundedCornerRadius = 12.dp// if (isSheetFullScreen) 0.dp else 12.dp
//    val modifier = if (isSheetFullScreen)
//        Modifier.fillMaxSize()
//    else
//        Modifier.fillMaxWidth()
//
//    BackHandler(modalSheetState.isVisible) {
//        coroutineScope.launch { modalSheetState.hide() }
//    }
//
//    ModalBottomSheetLayout(
//        sheetState = modalSheetState,
//        sheetShape = RoundedCornerShape(topStart = roundedCornerRadius, topEnd = roundedCornerRadius),
//        sheetContent = {
//            Column(
//                modifier = modifier,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center,
//            ) {
//                Button(
//                    onClick = {
//                        isSheetFullScreen = !isSheetFullScreen
//                    }
//                ) {
//                    Text(text = "Toggle Sheet Fullscreen")
//                }
//
//                Button(
//                    onClick = {
//                        coroutineScope.launch { modalSheetState.hide() }
//                    }
//                ) {
//                    Text(text = "Hide Sheet")
//                }
//            }
//        }
//    ) {
//        Scaffold {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize(),
//                contentAlignment = Alignment.Center,
//            ) {
//                Button(
//                    onClick = {
//                        coroutineScope.launch {
//                            if (modalSheetState.isVisible)
//                                modalSheetState.hide()
//                            else {
//                                modalSheetState.show()
//
//                            }
//                        }
//                    },
//                ) {
//                    Text(text = "Open Sheet")
//                }
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//fun PreviewBottomSheetLayout(){
//    BottomSheetLayout()
//}