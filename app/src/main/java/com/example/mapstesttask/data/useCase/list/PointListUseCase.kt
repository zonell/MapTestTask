package com.example.mapstesttask.data.useCase.list

import com.example.mapstesttask.data.model.pointListResponse.PointListResponse
import retrofit2.Response

/**
 * Created by O.Dziuba on 25.10.2023.
 */
interface PointListUseCase {
    suspend fun getPointList(): Response<PointListResponse>
}