package com.example.mapstesttask.data.useCase.direction

import com.example.mapstesttask.data.model.directioRespone.DirectionResponse
import retrofit2.Response

/**
 * Created by O.Dziuba on 26.10.2023.
 */
interface DirectionUseCase {
    suspend fun getRoute(
        start: String,
        end: String
    ): Response<DirectionResponse>

}