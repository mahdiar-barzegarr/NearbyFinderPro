package ir.company.namadapplication

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import ir.company.namadapplication.navigation.NavigationSetup
import ir.company.namadapplication.ui.theme.NamadApplicationTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSetup()
//            TestScreen()
        }


    }

    @SuppressLint("UseKtx")
    @Composable
    fun TestScreen() {

        val context = LocalContext.current

        // مختصات مبدأ
        val lat = 32.7114088
        val lon = 51.6400845

//        // نام مقصد برای جستجو
//        val destinationQuery = "بیمارستان سوانح سوختگی امام موسی کاظم"
//
//        // Intent برای گوگل مپ یا هر برنامه مسیریابی که geo: رو پشتیبانی کنه
//        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:$lat,$lon?q=$destinationQuery"))

        val destinationQuery = "بیمارستان سوانح سوختگی امام موسی کاظم"

// فقط متن جستجو، بدون مختصات
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("geo:0,0?q=$destinationQuery")
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    try {
                        // استاندارد اندروید: مستقیماً startActivity و در صورت نبود برنامه catch کن
                        context.startActivity(
                            Intent.createChooser(intent, "انتخاب برنامه مسیریابی")
                        )
                    } catch (e: ActivityNotFoundException) {
                        // هیچ برنامه مسیریابی نصب نیست
                        Toast.makeText(
                            context,
                            "هیچ برنامه مسیریابی‌ای نصب نیست",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            ) {
                Text("نمایش مسیر")
            }
        }
    }




}

