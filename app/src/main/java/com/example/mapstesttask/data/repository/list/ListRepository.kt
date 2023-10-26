package com.example.mapstesttask.data.repository.list

import com.example.mapstesttask.data.model.pointListResponse.PointListResponse
import retrofit2.Response

/**
 * Created by O.Dziuba on 25.10.2023.
 */
interface ListRepository {
    suspend fun getPointList(): Response<PointListResponse>
}