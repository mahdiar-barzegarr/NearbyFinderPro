package ir.company.namadapplication.ui.screen

import android.content.Context
import android.content.Intent
import android.location.LocationManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val VazirFontFamily = FontFamily(Font(R.font.vazirmatn))
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    var visible by remember { mutableStateOf(false) }
    var buttonEnable by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()

    // ---------- States ----------
    val isLoading = viewModel.isLoading.collectAsState()
    val observerInternet = viewModel.observer.online.collectAsState(true)
    val isGpsEnabled = viewModel.isGpsEnabled.collectAsState()
    val location by viewModel.savedLocation.collectAsState()


    // ---------- Permission Launcher ----------
    val locationPermissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->

            val granted = permissions.any { it.value }
            if (granted) {
                viewModel.forceCheckGps()
                viewModel.fetchUserLocation() // ✅ مهم
            }
        }



    LaunchedEffect(Unit) {
        delay(300)
        visible = true
        locationPermissionLauncher.launch(
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }


    // ---------- UI ----------
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
            ) {
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
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            when {
                                !observerInternet.value && !isGpsEnabled.value -> {
                                    IconButton({
                                        context.startActivity(Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                                    }) {
                                        Icon(
                                            Icons.Default.LocationOn,
                                            contentDescription = "",
                                            modifier = Modifier
                                                .border(1.dp, Color.Black, CircleShape)
                                                .padding(8.dp)
                                        )
                                    }
                                    IconButton({
                                        context.startActivity(Intent(android.provider.Settings.ACTION_WIFI_SETTINGS))
                                    }) {
                                        Icon(
                                            painter = painterResource(R.drawable.wifi),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .border(1.dp, Color.Black, CircleShape)
                                                .padding(8.dp)
                                        )
                                    }
                                }

                                !observerInternet.value -> {
                                    IconButton({
                                        context.startActivity(Intent(android.provider.Settings.ACTION_WIFI_SETTINGS))
                                    }) {
                                        Icon(
                                            painter = painterResource(R.drawable.wifi),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .border(1.dp, Color.Black, CircleShape)
                                                .padding(8.dp)
                                        )
                                    }
                                }

                                !isGpsEnabled.value -> {
                                    IconButton({
                                        context.startActivity(Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                                    }) {
                                        Icon(
                                            Icons.Default.LocationOn,
                                            contentDescription = "",
                                            modifier = Modifier
                                                .border(1.dp, Color.Black, CircleShape)
                                                .padding(8.dp)
                                        )
                                    }
                                }
                            }
                        }

                        if (observerInternet.value && isGpsEnabled.value) {
                            LottieAnimation(
                                composition = composition,
                                iterations = Int.MAX_VALUE,
                                modifier = Modifier.size(290.dp, 30.dp),
                                contentScale = ContentScale.FillWidth,
                                speed = 0.6f
                            )
                        }

                        Spacer(Modifier.height(8.dp))

                        val errorMessage = when {
                            !observerInternet.value && !isGpsEnabled.value -> "اتصال اینترنت و لوکیشن خود را بررسی کنید"
                            !observerInternet.value -> "اتصال اینترنت خود را بررسی کنید"
                            !isGpsEnabled.value -> "لوکیشن خود را بررسی کنید"
                            else -> ""
                        }

                        if (errorMessage.isNotEmpty()) {
                            Text(
                                text = errorMessage,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(observerInternet.value, isGpsEnabled.value) {
        if (observerInternet.value && isGpsEnabled.value) {
            delay(2500)
            navController.navigate("home") {
                popUpTo(navController.graph.startDestinationId) { inclusive = true }
                launchSingleTop = true
            }
        }
    }

}

@Composable
fun rememberGpsState(context: Context): Boolean {
    var isGpsEnabled by remember { mutableStateOf(false) }
    val locationManager =
        remember { context.getSystemService(Context.LOCATION_SERVICE) as LocationManager }

    // بررسی اولیه
    LaunchedEffect(Unit) {
        isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    // مدیریت listener با DisposableEffect
    DisposableEffect(Unit) {
        val gpsCallback = object : android.location.LocationListener {
            override fun onLocationChanged(location: android.location.Location) {
                isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            }

            override fun onProviderEnabled(provider: String) {
                if (provider == LocationManager.GPS_PROVIDER) isGpsEnabled = true
            }

            override fun onProviderDisabled(provider: String) {
                if (provider == LocationManager.GPS_PROVIDER) isGpsEnabled = false
            }

            override fun onStatusChanged(
                provider: String?,
                status: Int,
                extras: android.os.Bundle?
            ) {
            }
        }

        try {
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000L,
                0f,
                gpsCallback
            )
        } catch (_: SecurityException) {
            // دسترسی لوکیشن داده نشده
        }

        onDispose {
            locationManager.removeUpdates(gpsCallback)
        }
    }

    return isGpsEnabled
}

