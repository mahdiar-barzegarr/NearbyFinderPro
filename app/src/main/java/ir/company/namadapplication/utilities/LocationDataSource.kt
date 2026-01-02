package ir.company.namadapplication.utilities

import android.annotation.SuppressLint
import android.health.connect.datatypes.ExerciseRoute
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.android.gms.location.FusedLocationProviderClient
import ir.company.namadapplication.data.model.UserLocation
import jakarta.inject.Inject

class LocationDataSource @Inject constructor(
    private val fusedLocationClient: FusedLocationProviderClient
) {

    @SuppressLint("MissingPermission")
    fun getLastLocation(
        onResult: (UserLocation?) -> Unit
    ) {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    onResult(
                        UserLocation(
                            lat = location.latitude,
                            lng = location.longitude
                        )
                    )
                } else {
                    onResult(null)
                }
            }
    }

}
