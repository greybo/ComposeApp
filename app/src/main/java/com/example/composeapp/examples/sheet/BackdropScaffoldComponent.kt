package com.example.composeapp.examples.sheet

//
//@Composable
//fun BackdropScaffoldComponent() {
//    val scope = rememberCoroutineScope()
//    val selection = remember { mutableStateOf(1) }
//    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed)
//    LaunchedEffect(scaffoldState) {
//        scaffoldState.reveal()
//    }
//    BackdropScaffold(
//        scaffoldState = scaffoldState,
//        appBar = {
//            TopAppBar(
//                title = { Text("Backdrop scaffold") },
//                navigationIcon = {
//                    if (scaffoldState.isConcealed) {
//                        IconButton(onClick = { scope.launch { scaffoldState.reveal() } }) {
//                            Icon(Icons.Default.Menu, contentDescription = "Localized description")
//                        }
//                    } else {
//                        IconButton(onClick = { scope.launch { scaffoldState.conceal() } }) {
//                            Icon(Icons.Default.Close, contentDescription = "Localized description")
//                        }
//                    }
//                },
//                actions = {
//                    var clickCount by remember { mutableStateOf(0) }
//                    IconButton(
//                        onClick = {
//                            // show snackbar as a suspend function
//                            scope.launch {
//                                scaffoldState.snackbarHostState
//                                    .showSnackbar("Snackbar #${++clickCount}")
//                            }
//                        }
//                    ) {
//                        Icon(Icons.Default.Favorite, contentDescription = "Localized description")
//                    }
//                },
//                elevation = 0.dp,
//                backgroundColor = Color.Transparent
//            )
//        },
//        backLayerContent = {
//            LazyColumn {
//                items(if (selection.value >= 3) 3 else 15) {
//                    ListItem(
//                        Modifier.clickable {
//                            selection.value = it
//                            scope.launch { scaffoldState.conceal() }
//                        },
//                        text = { Text("Select $it") }
//                    )
//                }
//            }
//        },
//        frontLayerContent = {
//            Text("Selection: ${selection.value}")
//            LazyColumn {
//                items(50) {
//                    ListItem(
//                        text = { Text("Item $it") },
//                        icon = {
//                            Icon(
//                                Icons.Default.Favorite,
//                                contentDescription = "Localized description"
//                            )
//                        }
//                    )
//                }
//            }
//        }
//    )
//
//}
//
//@Preview
//@Composable
//fun PreviewExampleComponent() {
//    BackdropScaffoldComponent()
//}