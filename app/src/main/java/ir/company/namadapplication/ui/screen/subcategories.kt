package ir.company.namadapplication.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Subcategories(navController: NavController){

}
@Preview(
    showBackground = true, showSystemUi = true, heightDp = 1500
)
@Composable
fun Subcategories() {
    Subcategories(rememberNavController())
}

