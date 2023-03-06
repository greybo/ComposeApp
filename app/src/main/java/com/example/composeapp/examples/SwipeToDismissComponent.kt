package com.example.composeapp.examples

//
//data class SwipeToModel(val id: Int, val data: String)
//
//@Composable
//fun SwipeToDismissComponent() {
//
//    val todoListState = remember {
//        mutableStateListOf(
//            SwipeToModel(1, "one"),
//            SwipeToModel(2, "two"),
//            SwipeToModel(3, "three"),
//            SwipeToModel(4, "four"),
//        )
//    }
//    val lazyListState = rememberLazyListState()
//    val scope = rememberCoroutineScope()

//    LazyColumn(
//        modifier = Modifier.fillMaxHeight(),
//        state = lazyListState
//    ) {
//        items(
//            items = todoListState.toList(),
//            key = { it.id }
//        ) { item2 ->
//            fun callbackDelete(item: SwipeToModel) {
//                todoListState.remove(item)
//                Log.i(
//                    "SwipeToDismissComponent",
//                    "changed list: ${todoListState.joinToString(", ")}"
//                )
//            }
//
//            val currentItem by rememberUpdatedState(item2)
//            val dismissState = rememberDismissState(
//                confirmStateChange = {
//                    when (it) {
////                        DismissValue.DismissedToEnd -> {
////                            true
////                        }
//                        DismissValue.DismissedToStart -> {
//                            callbackDelete(currentItem)
//                            true
//                        }
//                        else -> {
//                            false
//                        }
//                    }
//                }
//            )
//
//            SwipeToDismiss(
//                state = dismissState,
//                modifier = Modifier
//                    .padding(vertical = 1.dp),
////                        .animateItemPlacement(),
//                directions = setOf(
//                    DismissDirection.StartToEnd,
//                    DismissDirection.EndToStart
//                ),
//                dismissThresholds = { direction ->
//                    FractionalThreshold(
//                        //Threshold for change color background
//                        if (direction == DismissDirection.StartToEnd) 0.55f else 0.45f
//                    )
//                },
//                background = {
//                    SwipeBackground(dismissState)
//                },
//                dismissContent = {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(Color.Yellow),
//                        horizontalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            text = currentItem.data,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(start = 24.dp, top = 16.dp, bottom = 16.dp)
//                        )
//                    }
//                }
//            )
//        }
//    }
//
//}
//
//@Composable
//fun SwipeBackground(dismissState: DismissState) {
//    val direction = dismissState.dismissDirection ?: return
//
//    val color by animateColorAsState(
//        when (dismissState.targetValue) {
//            DismissValue.Default -> Color.LightGray
//            DismissValue.DismissedToEnd -> Color.Green
//            DismissValue.DismissedToStart -> Color.Red
//        }
//    )
//    val alignment = when (direction) {
//        DismissDirection.StartToEnd -> Alignment.CenterStart
//        DismissDirection.EndToStart -> Alignment.CenterEnd
//    }
//    val icon = when (direction) {
//        DismissDirection.StartToEnd -> Icons.Default.Done
//        DismissDirection.EndToStart -> Icons.Default.Delete
//    }
//    val scale by animateFloatAsState(
//        if (dismissState.targetValue == DismissValue.Default) 0.75f else 1.2f
//    )
//
//    Box(
//        Modifier
//            .fillMaxSize()
//            .background(color)
//            .padding(horizontal = 20.dp),
//        contentAlignment = alignment
//    ) {
//        Icon(
//            icon,
//            contentDescription = "Localized description",
//            modifier = Modifier.scale(scale)
//        )
//    }
//}