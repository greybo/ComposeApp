package com.example.composeapp.router

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.examples.messages.ListGreeting
import com.example.composeapp.main.ComposeDetailsMain

@Preview
@Composable
fun RouterCompose(navController: NavHostController = rememberNavController()) {

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = RouterScreenType.DetailMain.name
    ) {

        composable(RouterScreenType.DetailMain.name) {
            ComposeDetailsMain(callback = { item ->
                navController.navigate(item.name)
//                when (item) {
//                    MainRouterType.ToolbarAppComponent -> navController.navigate(RouterScreenType.Color.name)
//                    MainRouterType.Components -> navController.navigate(RouterScreenType.Components.name)
//                    MainRouterType.Typography -> navController.navigate(RouterScreenType.Typography.name)
//                    MainRouterType.Collections -> navController.navigate(RouterScreenType.Collections.name)
//                    MainRouterType.Whatson -> navController.navigate(RouterScreenType.Whatson.name)
//                    else -> {}
//                }
            })
        }
        composable(RouterScreenType.Tutorial1Greeting.name){
            ListGreeting()
        }
//        composable(
//            route = RouterScreenType.Details.name + "/{hitId}",
//        ) {
////            DetailsScreen(navController)
//        }
//        composable(
//            route = RouterScreenType.SeeAll.name + "/{category}",
//            arguments = listOf(navArgument("category") {
//                type = NavType.StringType
//                defaultValue = "user1234"
//            }
//            )
//        ) {
////            CategoriesScreen(navController)
//        }
    }

}

