package ir.company.namadapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.company.namadapplication.ui.screen.SplashScreen


@Composable
fun NavigationSetup() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route
    ) {


        composable(
            route = Screens.SplashScreen.route
        ) {
            SplashScreen(navController = navController)
        }


    }


}