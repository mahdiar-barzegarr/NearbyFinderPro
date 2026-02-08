package ir.company.namadapplication.data.remote.remoteRepo

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import com.google.gson.Gson
import ir.company.namadapplication.data.remote.api.ApiService
import ir.company.namadapplication.data.remote.remoteModel.PlacesResponse
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getNearbyPlaceName(
        layer: String,
        lat: Double,
        lng: Double
    ): Result<String> {
        return try {
            val response = apiService.getNearbyPlaces(
                location = "$lat,$lng",
                layer = layer,
                searchRadius = 5000
            )

            if (response.isSuccessful) {
                val body = response.body()
                Log.d("API_BODY", Gson().toJson(body))

                val nearestName = body?.layerPoints?.nearestPoints?.firstOrNull()?.name
                Result.success(nearestName ?: "No name found")
            } else {
                val errorJson = response.errorBody()?.string()
                Log.e("API_ERROR_BODY", errorJson ?: "Unknown error")
                Result.failure(Exception(errorJson ?: "Unknown error"))
            }

        } catch (e: Exception) {
            Log.e("API_EXCEPTION", e.toString())
            Result.failure(e)
        }
    }



}

