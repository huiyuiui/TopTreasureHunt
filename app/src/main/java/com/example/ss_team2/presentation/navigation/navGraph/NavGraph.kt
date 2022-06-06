package com.example.ss_team2.presentation.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ss_team2.presentation.navigation.MainScreen
import com.example.ss_team2.presentation.navigation.ROOT_GRAPH_ROUTE
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.chatList.ChatList
import com.example.ss_team2.presentation.ui.chatRoom.Dialog
import com.example.ss_team2.presentation.ui.firstpage.FirstPage
import com.example.ss_team2.presentation.ui.mapScreen.MapScreen
import com.example.ss_team2.presentation.ui.registerPage.RegisterPage
import com.example.ss_team2.presentation.ui.shop.Shop
import com.example.ss_team2.presentation.ui.welcome.Welcome

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.First.route,
        route = ROOT_GRAPH_ROUTE
    ) {
        findNavGraph(navController = navController)
        lostNavGraph(navController = navController)
        composable(
            route = Screen.First.route
        ){
            FirstPage(navController = navController)
        }
        composable(
            route = Screen.Register.route
        ){
            RegisterPage(navController = navController)
        }
        composable(
            route = Screen.Login.route
        ){
            Welcome(navController = navController)
        }
        composable(
            route = Screen.Home.route
        ){
            MainScreen()
        }
        composable(
            route = Screen.Map.route
        ){
            MapScreen(navController = navController)
        }
        composable(
            route = Screen.ChatList.route
        ){
            ChatList(navController = navController)
        }
        composable(
            route = Screen.Shop.route
        ){
            Shop()
        }
        composable(
            route = Screen.ChatRoom.route
        ){
            Dialog()
        }
    }
}