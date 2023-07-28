package com.keepcoding.androidsuperpoderes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ){
        addLoginScreen(navController)
        addForgotPassword(navController)
        addHeroList(navController)
        addHeroDetail(navController)
    }
}