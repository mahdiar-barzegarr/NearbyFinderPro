package ir.company.namadapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.company.namadapplication.ui.screen.HomeScreen
import ir.company.namadapplication.ui.screen.SplashScreen
import ir.company.namadapplication.ui.screen.Subcategories


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

        composable(
            route = Screens.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screens.Subcategories.route
        ) {
            Subcategories(navController = navController)
        }


    }


}