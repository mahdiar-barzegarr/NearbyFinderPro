package ir.company.namadapplication.utilities

import androidx.datastore.preferences.core.doublePreferencesKey

object DataStoreKeys {
    val LAT = doublePreferencesKey("user_lat")
    val LNG = doublePreferencesKey("user_lng")
}
