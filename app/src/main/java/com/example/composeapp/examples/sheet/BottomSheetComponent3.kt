package com.example.composeapp.examples.sheet

//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@OptIn( ExperimentalComposeUiApi::class)
//@Composable
//fun BottomSheetLayout3() {
//    val context = LocalContext.current
//
//    val coroutineScope = rememberCoroutineScope()
//    val modalSheetState = rememberModalBottomSheetState(
//        initialValue = ModalBottomSheetValue.Hidden,
//        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded },
//        skipHalfExpanded = false
//    )
//    var isSheetFullScreen by remember { mutableStateOf(false) }
//    val focusRequester1 = remember { FocusRequester() }
//    val focusRequester2 = remember { FocusRequester() }
//
//    val roundedCornerRadius = 12.dp// if (isSheetFullScreen) 0.dp else 12.dp
//    val modifier = if (isSheetFullScreen)
//        Modifier.fillMaxSize()
//    else
//        Modifier.fillMaxWidth()
//
//    LaunchedEffect(modalSheetState.currentValue) {
//        if (modalSheetState.currentValue == ModalBottomSheetValue.Hidden) {
//            context.hideKeyboard()
//        } else {
//            context.showKeyboard()
//            focusRequester2.requestFocus()
//        }
//    }
//
//    BackHandler(modalSheetState.isVisible) {
//        coroutineScope.launch { modalSheetState.hide() }
//    }
//
//    ModalBottomSheetLayout(
//        sheetState = modalSheetState,
//        sheetShape = RoundedCornerShape(
//            topStart = roundedCornerRadius,
//            topEnd = roundedCornerRadius
//        ),
//        sheetContent = {
//            Column(
//                modifier = modifier,//Modifier.fillMaxSize(),//
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Top,
//            ) {
//
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
//
//                Row(
//                    modifier = Modifier
//                        .padding(top = 16.dp).fillMaxWidth()
//                        .align(Alignment.CenterHorizontally),
//                    horizontalArrangement = Arrangement.SpaceEvenly,
//                ) {
//                    val label1 = "Кількість"
//                    val label2 = "Ціна"
//                    val text1 = "field one"
//                    val text2 = "field two"
//                    var field_1 by remember { mutableStateOf(text1) }
//                    var field_2 by remember { mutableStateOf(text2) }
//
//                    OutlinedTextField(
//                        value = field_1,
//                        singleLine = true,
//                        modifier = Modifier
//                            .padding(all = 16.dp)
//                            .fillMaxWidth(0.35f)
//                            .focusRequester(focusRequester1),
//                        onValueChange = { field_1 = it },
//                        label = { Text(label1) },
//                        keyboardOptions = KeyboardOptions.Default.copy(
//                            imeAction = ImeAction.Done
//                        ),
//                        keyboardActions = KeyboardActions(
//                            onDone = { context.hideKeyboard() }
//                        ),
//                    )
//
//                    OutlinedTextField(
//                        value = field_2,
//                        singleLine = true,
//                        modifier = Modifier
//                            .padding(all = 16.dp)
//                            .fillMaxWidth(0.5f)
//                            .focusRequester(focusRequester2),
//                        onValueChange = { field_2 = it },
//                        label = { Text(label2) },
//                        keyboardOptions = KeyboardOptions.Default.copy(
//                            imeAction = ImeAction.Done
//                        ),
//                        keyboardActions = KeyboardActions(
//                            onDone = { context.hideKeyboard() }
//                        ),
//                    )
//                }
//            }
//        }
//    ) {
//
//        Scaffold {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center,
//            ) {
//                Text(
//                    text = modalSheetState.currentValue.toString(),
//                    modifier = Modifier.align(Alignment.TopCenter)
//                )
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
//fun PreviewBottomSheetLayout3() {
//    BottomSheetLayout3()
//}