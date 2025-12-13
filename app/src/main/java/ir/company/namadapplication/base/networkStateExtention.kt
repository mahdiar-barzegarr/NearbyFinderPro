package ir.company.namadapplication.base

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.annotation.RequiresPermission

fun Context.isNetworkState(): Boolean{
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val nw = cm.activeNetwork ?: return false

    val caps = cm.getNetworkCapabilities(nw) ?: return false

    return caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) && caps.hasCapability(
        NetworkCapabilities.NET_CAPABILITY_VALIDATED)
}