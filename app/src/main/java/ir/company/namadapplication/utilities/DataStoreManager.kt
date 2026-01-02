package ir.company.namadapplication.utilities

import android.content.Context
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.company.namadapplication.data.model.UserLocation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreManager @Inject constructor(
    @ApplicationContext private val context: Context
) {

    suspend fun saveLocation(location: UserLocation) {
        context.dataStore.edit { prefs ->
            prefs[DataStoreKeys.LAT] = location.lat
            prefs[DataStoreKeys.LNG] = location.lng
        }
    }


    val locationFlow: Flow<UserLocation?> =
        context.dataStore.data.map { prefs ->
            val lat = prefs[DataStoreKeys.LAT]
            val lng = prefs[DataStoreKeys.LNG]

            if (lat != null && lng != null)
                UserLocation(lat, lng)
            else null
        }
}
