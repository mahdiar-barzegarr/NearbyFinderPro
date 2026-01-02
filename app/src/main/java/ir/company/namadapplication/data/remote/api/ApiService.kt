package ir.company.namadapplication.data.remote.api

import ir.company.namadapplication.data.remote.remoteModel.PlacesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("v2/places")
    suspend fun getNearbyPlaces(
        @Query("categories") categories: String,
        @Query("filter") filter: String,
        @Query("limit") limit: Int,
        @Query("apiKey") apiKey: String
    ): PlacesResponse

}
