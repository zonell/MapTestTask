package com.example.mapstesttask.data.repository.direction

import com.example.mapstesttask.data.model.directioRespone.DirectionResponse
import com.example.mapstesttask.data.network.NetworkManager
import retrofit2.Response

/**
 * Created by O.Dziuba on 26.10.2023.
 */
class DirectionRepositoryImpl(
    private val mapManager: NetworkManager
) : DirectionRepository {

    private val apiKey = "5b3ce3597851110001cf62487bab063098f84329a8480dd95f5397d7"

    override suspend fun getRoute(
        start: String,
        end: String
    ): Response<DirectionResponse> {
        return mapManager.getRoute(apiKey, start, end)
    }
}