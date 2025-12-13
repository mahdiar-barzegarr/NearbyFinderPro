package ir.company.namadapplication.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import ir.company.namadapplication.R
import ir.company.namadapplication.ui.theme.ThemeLightColorScheme
import ir.company.namadapplication.viewModel.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {

    val VazirFontFamily = FontFamily(
        Font(R.font.vazirmatn)
    )

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.loading)
    )

    var visible by remember { mutableStateOf(false) }
    var buttonEnable by remember { mutableStateOf(true) }

    val scope = rememberCoroutineScope()


    val netState by viewModel.state.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()
    val observerInternet = viewModel.observer.online.collectAsState(true)


    LaunchedEffect(Unit) {
        delay(300)
        visible = true
    }



    LaunchedEffect(netState) {
        if (netState == true) {
            delay(2500)
            navController.navigate("home") {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
                launchSingleTop = true
            }

        }
    }


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



            Spacer(Modifier.height(16.dp))



            Text(
                text = "MakanYab",
                color = ThemeLightColorScheme.secondary,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = VazirFontFamily,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )


            Spacer(Modifier.height(52.dp))


            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(animationSpec = tween(1400)) +
                        scaleIn(animationSpec = tween(1400))
            )
            {
                if (isLoading.value) {
                    LottieAnimation(
                        composition = composition,
                        iterations = Int.MAX_VALUE,
                        modifier = Modifier.size(290.dp, 30.dp),
                        contentScale = ContentScale.FillWidth,
                        speed = 0.6f
                    )
                } else {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedButton(
                            {
                                scope.launch {
                                    buttonEnable = false
                                    delay(1000)
                                    buttonEnable = true
                                }
                                if (observerInternet.value) {
                                    viewModel.retryLoading()
                                }
                            },
                            enabled = buttonEnable
                        ) {
                            Text("تلاش مجدد")
                        }
                        Text("اتصال اینترنت خود را بررسی کنید")
                    }

                }

            }
        }
    }
}


