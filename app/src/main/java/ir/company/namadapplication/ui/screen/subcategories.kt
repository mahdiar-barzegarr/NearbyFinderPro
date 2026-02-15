package ir.company.namadapplication.ui.screen

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ir.company.namadapplication.viewModel.SubcategoriesViewModel
import kotlinx.coroutines.delay

@Composable
fun Subcategories(
    navController: NavController,
    viewModel: SubcategoriesViewModel = hiltViewModel(),
    id: String
) {
    val locationId = id.toIntOrNull() ?: 1
    val context = LocalContext.current


    LaunchedEffect(locationId) {
        viewModel.loadSubcategories(locationId)
    }

    val subcategories by viewModel.data.collectAsState()
    val location by viewModel.nearestLocation.collectAsState()
    val lastLocation by viewModel.lastLocation.collectAsState()
    var loadingPage by remember {
        mutableStateOf(false)
    }


    LaunchedEffect(location) {

        location?.let { safeLocation ->

            delay(500)

            viewModel.openMaps(
                context,
                safeLocation.lat,
                safeLocation.lng
            )

            loadingPage = false

        }

    }





    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffF8FAFF)),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {

            item {
                Column(
                    modifier = Modifier.padding(top = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Text(
                        "NazdikYab",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(
                        "پیدا کردن نزدیک ترین مکان ها به شما", color = Color.DarkGray, fontSize = 18.sp
                    )
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                    ) {
                        val strokeWidth = 8f

                        drawLine(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color.Transparent, Color.Black, Color.Transparent
                                )
                            ),
                            start = Offset(0f, size.height / 2),
                            end = Offset(size.width, size.height / 2),
                            strokeWidth = strokeWidth,
                            cap = StrokeCap.Round
                        )
                    }
                }
            }

            items(subcategories) { item ->
                SubCategoriesBox(
                    title = item.title,
                    icon = item.icon,
                    color = item.color,
                    onClick = {
                        loadingPage = true
                        viewModel.findNearestPlace(
                            apiCategory = item.apiCategory,
                            lat = lastLocation?.lat ?: 0.0,
                            lng = lastLocation?.lng ?: 0.0,
                        )
                    }
                )
            }
        }
        if (loadingPage) {
            LoadingOverlay()
        }
    }


}

@Composable
fun SubCategoriesBox(
    title: String,
    icon: Int,
    color: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(168.dp)
            .padding(horizontal = 12.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )

            Text(
                title,
                fontSize = 22.sp,
                fontWeight = FontWeight(600),
                color = Color.Black
            )

            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SubcategoriesPreview() {
    Subcategories(
        navController = rememberNavController(),
        id = "1"
    )
}