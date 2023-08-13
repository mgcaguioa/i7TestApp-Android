package com.mgcaguioa.i7testapp_android

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mgcaguioa.i7testapp_android.screens.ActionLogsScreen
import com.mgcaguioa.i7testapp_android.screens.MainScreen

fun NavGraphBuilder.mainGraph(navController: NavController) {
    navigation(startDestination = MainNavOption.MainScreen.name, route = "MainRoute") {
        composable(MainNavOption.MainScreen.name) {
            MainScreen(navController)
        }
        composable(MainNavOption.ActionLogsScreen.name) {
            ActionLogsScreen(navController)
        }
    }
}

enum class MainNavOption {
    MainScreen,
    ActionLogsScreen
}