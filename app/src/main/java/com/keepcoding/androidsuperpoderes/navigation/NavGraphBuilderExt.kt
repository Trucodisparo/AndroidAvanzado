package com.keepcoding.androidsuperpoderes.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.keepcoding.androidsuperpoderes.presentation.detail.HeroDetailScreen
import com.keepcoding.androidsuperpoderes.presentation.forgotPassword.ForgotPasswordScreen
import com.keepcoding.androidsuperpoderes.presentation.login.LoginScreen
import com.keepcoding.androidsuperpoderes.presentation.heroList.HeroListScreen


fun NavGraphBuilder.addLoginScreen(navController: NavController){
    composable(Screen.LoginScreen.route){
        LoginScreen (
            onForgot = { navController.navigate(Screen.ForgotPasswordScreen.route) },
            onLoginSuccess = { navController.navigate(Screen.HeroListScreen.route) }
        )
    }
}

fun NavGraphBuilder.addForgotPassword(navController: NavController){
    composable(Screen.ForgotPasswordScreen.route){
        ForgotPasswordScreen()
    }
}

fun NavGraphBuilder.addHeroList(navController: NavController){
    composable(Screen.HeroListScreen.route){
        HeroListScreen{heroId ->
            navController.navigate("${Screen.HeroDetailScreen.route}/$heroId")
        }
    }
}

fun NavGraphBuilder.addHeroDetail(navController: NavController){
    composable(route = Screen.HeroDetailScreen.route + "/{heroId}",
    arguments = Screen.HeroDetailScreen.arguments){
        navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getString("heroId") ?: ""
        HeroDetailScreen(id = id)
    }
}