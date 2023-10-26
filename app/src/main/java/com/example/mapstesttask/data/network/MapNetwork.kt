package com.example.mapstesttask.data.network

import com.example.mapstesttask.data.model.directioRespone.DirectionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by O.Dziuba on 26.10.2023.
 */
interface MapNetwork {

    @GET("directions/driving-car")
    suspend fun getRoute(
        @Query("api_key") apiKey: String,
        @Query("start") start: String,
        @Query("end") end: String
    ): Response<DirectionResponse>

}