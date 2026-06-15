package ir.company.namadapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
            route = Screens.Subcategories.routeWithArgs("0:id", "1:title"),
            arguments = listOf(
                navArgument("0") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("1") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getString("0") ?: ""
            val title = backStackEntry.arguments?.getString("1") ?: ""

            Subcategories(
                navController = navController,
                id = id,
                title = title
            )
        }


    }


}