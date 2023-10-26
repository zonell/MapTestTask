package com.example.mapstesttask.data.network

import com.example.mapstesttask.data.model.directioRespone.DirectionResponse
import com.example.mapstesttask.data.model.pointListResponse.PointListResponse
import retrofit2.Response

/**
 * Created by O.Dziuba on 25.10.2023.
 */
class NetworkManagerImpl(
    private val apiNetwork: ApiNetwork,
    private val mapNetwork: MapNetwork
): NetworkManager {
    //API
    override suspend fun getPointList(): Response<PointListResponse> {
        return apiNetwork.getPointList()
    }

    //MAP
    override suspend fun getRoute(
        apiKey: String,
        start: String,
        end: String
    ): Response<DirectionResponse> {
        return mapNetwork.getRoute(apiKey, start, end)
    }

}