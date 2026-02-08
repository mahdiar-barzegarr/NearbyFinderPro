package ir.company.namadapplication.data.remote.api

import ir.company.namadapplication.data.remote.remoteModel.PlacesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/nearby")
    suspend fun getNearbyPlaces(
        @Query("location") location: String,
        @Query("layer") layer: String,
        @Query("searchRadius") searchRadius: Int
    ): Response<PlacesResponse>
}



