package ir.company.namadapplication.ui.screen

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ir.company.namadapplication.R
import ir.company.namadapplication.utilities.AppText
import ir.company.namadapplication.viewModel.SubcategoriesViewModel
import kotlinx.coroutines.delay

@Composable
fun Subcategories(
    navController: NavController,
    viewModel: SubcategoriesViewModel = hiltViewModel(),
    id: String,
    title: String
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
    var showFailedLocate by remember { mutableStateOf(false) }



    LaunchedEffect(location) {
        location?.let { safeLocation ->
            delay(500)
            viewModel.openMaps(context, safeLocation.lat, safeLocation.lng)
            viewModel.resetNearestLocation()
            loadingPage = false
        }
    }


    LaunchedEffect(loadingPage) {
        if (loadingPage) {
            delay(6000)
            if (location == null) {
                loadingPage = false
                showFailedLocate = true
            }
        }
    }






    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffffedd4)),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {

            item {

                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 16.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )

                    Row(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AppText(title, color = Color.Green, fontWeight = FontWeight.Bold)

                        Icon(
                            Icons.Default.KeyboardArrowLeft,
                            contentDescription = null
                        )

                        AppText("خانه", color = Color.Black, fontWeight = FontWeight.Bold)

                        Icon(
                            Icons.Outlined.Home,
                            contentDescription = null
                        )
                    }
                }

                Column(
                    modifier = Modifier.padding(top = 15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    AppText(
                        "NazdikYab",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(
                        "پیدا کردن نزدیک ترین مکان ها به شما",
                        color = Color.DarkGray,
                        fontSize = 18.sp
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
        if (showFailedLocate) {
            Box(modifier = Modifier.fillMaxSize()) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(
                            radiusX = 20.dp,
                            radiusY = 20.dp,
                            edgeTreatment = BlurredEdgeTreatment.Unbounded
                        )
                        .background(Color.Black.copy(alpha = 0.45f))
                )

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    FailedLocate(
                        onDismiss = { showFailedLocate = false }
                    )
                }
            }
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

            AppText(
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


@Composable
fun FailedLocate(
    onDismiss: () -> Unit,
    image: Painter = painterResource(id = R.drawable.search_location)
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(
                    color = Color.White
                )
                .then(
                    Modifier.background(
                        color = Color.Transparent
                    )
                )

                .padding(1.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(
                        color = Color(0xFFFFFFFF).copy(alpha = 0.18f)
                    )
                    .padding(horizontal = 24.dp, vertical = 28.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {


                    Image(
                        painter = image,
                        contentDescription = "Location not found",
                        modifier = Modifier
                            .size(120.dp),
                        contentScale = ContentScale.Fit
                    )


                    Text(
                        text = "!مکانی پیدا نشد",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    AppText(
                        text = "در محدوده شما مکانی پیدا نشد",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = onDismiss,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xffffedd4),
                            contentColor = Color.White
                        )
                    ) {
                        AppText(
                            text = "بستن",
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SubcategoriesPreview() {
    Subcategories(navController = rememberNavController(), id = "0", title = "")
}