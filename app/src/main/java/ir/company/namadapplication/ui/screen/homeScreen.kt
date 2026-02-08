package ir.company.namadapplication.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
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
import ir.company.namadapplication.navigation.Screens
import ir.company.namadapplication.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController, viewModel: HomeViewModel = hiltViewModel()
) {

    val titleData by viewModel.data.collectAsState()



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
        items(titleData) {
            TitleBox(it.name, it.iconRes, it.color, {
                navController.navigate(
                    Screens.Subcategories.paramsWithArgs(it.id.toString())
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
            .padding(horizontal = 12.dp)
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

            Text(
                title,
                fontSize = 21.sp,
                fontWeight = FontWeight(600),
                fontFamily = FontFamily.Serif,
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