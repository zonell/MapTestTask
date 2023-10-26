package com.example.mapstesttask.data.network

import com.example.mapstesttask.data.model.directioRespone.DirectionResponse
import com.example.mapstesttask.data.model.pointListResponse.PointListResponse
import retrofit2.Response

/**
 * Created by O.Dziuba on 25.10.2023.
 */
interface NetworkManager {
    //API
    suspend fun getPointList(): Response<PointListResponse>

    //MAP
    suspend fun getRoute(apiKey: String,
                         start: String,
                         end: String
    ): Response<DirectionResponse>
}