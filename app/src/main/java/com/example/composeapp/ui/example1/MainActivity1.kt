package com.example.composeapp.ui.example1

//
//
//class MainActivity1 : ComponentActivity() {
//    @OptIn(ExperimentalMaterial3Api::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Scaffold(
//                topBar = {
//                    TopAppBar(
//                        title = {
//                            Text("METANIT.COM", fontSize = 22.sp)
//                        },
//                        navigationIcon = {
//                            IconButton(onClick = { }) { Icon(Icons.Filled.Menu, contentDescription = "Меню") }
//                        },
//                        actions = {
//                            Spacer(Modifier)
//                            IconButton(onClick = {
//
//                            }) {
//                                Icon(Icons.Filled.Search, contentDescription = "Поиск")
//                            }
//                        },
//                        colors = TopAppBarDefaults.mediumTopAppBarColors()
//                        //MaterialTheme.colorScheme.background
//                    )
//                },
//
//
//                bottomBar = {
//                    BottomAppBar {
//                        IconButton(onClick = { }) { Icon(Icons.Filled.Favorite, contentDescription = "Избранное") }
//                        Spacer(Modifier.weight(1f, true))
//                        IconButton(onClick = { }) { Icon(Icons.Filled.Info, contentDescription = "Информация о приложении") }
//                    }
//                }
//            ) {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//                it.calculateTopPadding().div(100.dp)
//                it.calculateRightPadding(LayoutDirection.Ltr).div(100.dp)
//            }
//        }
//    }
//
//
//}
