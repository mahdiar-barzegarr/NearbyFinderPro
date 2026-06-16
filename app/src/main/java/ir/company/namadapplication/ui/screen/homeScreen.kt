package ir.company.namadapplication.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ir.company.namadapplication.navigation.Screens
import ir.company.namadapplication.utilities.AppText
import ir.company.namadapplication.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController, viewModel: HomeViewModel = hiltViewModel()
) {

    val titleData by viewModel.data.collectAsState()



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .windowInsetsPadding(
                WindowInsets.systemBars
            )
            .padding(bottom = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        item {
            Column(
                modifier = Modifier.padding(vertical = 30.dp),
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
                AppText(
                    "پیدا کردن نزدیک ترین مکان ها به شما", color = Color.DarkGray, fontSize = 18.sp
                )
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                ) {

                    val path = Path().apply {

                        moveTo(0f, size.height * 0.2f)

                        quadraticBezierTo(
                            size.width / 2,
                            size.height * 1.3f,
                            size.width,
                            size.height * 0.2f
                        )
                    }

                    drawPath(
                        path = path,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color(0xFF34C759),
                                Color(0xFF84E89C),
                                Color(0xFFE5FFE5),
                                Color(0xFF84E89C),
                                Color(0xFF34C759)
                            )
                        ),
                        style = Stroke(
                            width = 4.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    )
                }
            }

        }
        items(titleData) {
            TitleBox(it.name, it.iconRes, it.color, {
                val colorsInt = it.brushColor.map { color ->
                    color.toArgb()
                }.toIntArray()

                navController.currentBackStackEntry
                    ?.savedStateHandle
                    ?.set("colors", colorsInt)


                navController.navigate(
                    Screens.Subcategories.paramsWithArgs(
                        it.id.toString(),
                        it.name,

                    )
                )
            })
        }
    }
}

@Composable
fun TitleBox(title: String, icon: Int, color: Color, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(168.dp)
            .padding(end = 12.dp, start = 12.dp, bottom = 18.dp)
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp, pressedElevation = 12.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, end = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            androidx.compose.foundation.Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )

            AppText(
                title,
                fontSize = 21.sp,
                fontWeight = FontWeight(600),
                color = Color(0xff1A1A1A),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        }
    }

}

@Preview(
    showBackground = true, showSystemUi = true, heightDp = 1500
)
@Composable
fun HomePreview() {
    HomeScreen(rememberNavController())
}