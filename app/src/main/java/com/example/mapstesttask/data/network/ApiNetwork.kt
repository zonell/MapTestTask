package com.example.mapstesttask.data.network

import com.example.mapstesttask.data.model.pointListResponse.PointListResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by O.Dziuba on 25.10.2023.
 */
interface ApiNetwork {

    @GET("v1/dictionaries")
    suspend fun getPointList(): Response<PointListResponse>
}