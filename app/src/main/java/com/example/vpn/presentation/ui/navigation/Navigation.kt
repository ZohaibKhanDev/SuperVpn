package com.example.vpn.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vpn.presentation.ui.screens.FaqScreen
import com.example.vpn.presentation.ui.screens.PrivacyPolicyScreen
import com.example.vpn.presentation.ui.screens.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) {
            HomeScreen(navController)
        }

        composable(Screens.Faq.route) {
            FaqScreen(navController = navController)
        }

        composable(Screens.Privacy_Policy.route) {
            PrivacyPolicyScreen(navController = navController)
        }
    }
}

sealed class Screens(
    val route: String
) {
    object Home : Screens("Home")
    object Faq : Screens("Faq")
    object Privacy_Policy : Screens("Privacy_Policy")
}