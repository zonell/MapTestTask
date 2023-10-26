package com.example.mapstesttask.data.repository.list

import com.example.mapstesttask.data.model.pointListResponse.PointListResponse
import com.example.mapstesttask.data.network.NetworkManager
import retrofit2.Response

/**
 * Created by O.Dziuba on 25.10.2023.
 */
class ListRepositoryImpl(
    private val networkManager: NetworkManager
): ListRepository {

    override suspend fun getPointList(): Response<PointListResponse> {
        return networkManager.getPointList()
    }
}