package ir.company.namadapplication.ui.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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

@Composable
fun Subcategories(
    navController: NavController,
    viewModel: SubcategoriesViewModel = hiltViewModel(),
    id: String
) {
    val locationId = id.toIntOrNull() ?: 1
    val context = LocalContext.current

    // 🔹 فرض: لوکیشن کاربر رو داری
    val userLat = 32.7114088
    val userLng = 51.6400845

    LaunchedEffect(locationId) {
        viewModel.loadSubcategories(locationId)
    }

    val subcategories by viewModel.data.collectAsState()
    val nearestPlaceName by viewModel.nearestPlaceName.collectAsState()

    // 🔹 وقتی API جواب داد → مسیریاب باز بشه
    LaunchedEffect(nearestPlaceName) {
        nearestPlaceName?.let { placeName ->
            val uri = Uri.parse("geo:0,0?q=$placeName")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(
                Intent.createChooser(intent, "انتخاب مسیریاب")
            )
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffF8FAFF)),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(subcategories) { item ->
            SubCategoriesBox(
                title = item.title,
                icon = item.icon,
                color = item.color,
                onClick = {
                    // 🔥 کلیک اصلی
                    viewModel.findNearestPlace(
                        apiCategory = item.apiCategory, // خیلی مهم
                        lat = userLat,
                        lng = userLng
                    )
                }
            )
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