package ir.company.namadapplication.navigation

import kotlin.collections.forEachIndexed

sealed class Screens(val route: String) {

    object SplashScreen: Screens("splashScreen")
    object Home: Screens("home")
    object Subcategories: Screens("subcat")


    fun routeWithArgs(vararg args: String) =
        buildString {
            append(route)
            args.forEachIndexed { index, string ->
                append("?$index={$index}")
            }
        }

    fun paramsWithArgs(vararg args: String) =
        buildString {
            append(route)
            args.forEachIndexed { index, string ->
                append("?$index=$string")
            }
        }

}