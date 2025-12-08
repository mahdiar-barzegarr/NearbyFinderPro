package ir.company.namadapplication.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices.PIXEL_5
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import ir.company.namadapplication.R
import ir.company.namadapplication.ui.theme.ThemeLightColorScheme

@Composable
fun SplashScreen(navController: NavController) {
    val VazirFontFamily = FontFamily(
        Font(R.font.vazirmatn)
    )

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ThemeLightColorScheme.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.icon),
                contentDescription = null
            )


            Text(
                "MakanYab",
                color = ThemeLightColorScheme.secondary,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = VazirFontFamily
            )

            Spacer(Modifier.height(32.dp))

            LottieAnimation(
                composition,
                iterations = Integer.MAX_VALUE,
                modifier = Modifier.size(
                    290.dp, 30.dp,
                ),
                contentScale = ContentScale.FillWidth,
                speed = 0.6f
            )

        }


    }


}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = PIXEL_5
)
@Composable
fun PreviewSplashScreen() {
    SplashScreen(rememberNavController())
}