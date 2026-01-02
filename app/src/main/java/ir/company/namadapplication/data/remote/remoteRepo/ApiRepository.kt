package ir.company.namadapplication.data.remote.remoteRepo

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import ir.company.namadapplication.data.remote.api.ApiService
import ir.company.namadapplication.data.remote.remoteModel.PlacesResponse
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getNearbyHospitals(
        lat: Double,
        lng: Double
    ): Result<PlacesResponse> {
        return safeGetData {
            apiService.getNearbyPlaces(
                categories = "healthcare.hospital",
                filter = "circle:$lng,$lat,5000",
                limit = 5,
                apiKey = "7cbd40a6530344b1ad1826fb108f26fa"
            )
        }
    }

    suspend fun <T> safeGetData(request: suspend () -> T): Result<T> {
        return try {
            Result.success(request())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
