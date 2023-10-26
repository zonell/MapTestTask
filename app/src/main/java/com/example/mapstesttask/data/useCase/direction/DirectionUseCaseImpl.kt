package com.example.mapstesttask.data.useCase.direction

import com.example.mapstesttask.data.model.directioRespone.DirectionResponse
import com.example.mapstesttask.data.repository.direction.DirectionRepository
import retrofit2.Response

/**
 * Created by O.Dziuba on 26.10.2023.
 */
class DirectionUseCaseImpl(
    private val directionRepository: DirectionRepository
): DirectionUseCase {
    override suspend fun getRoute(start: String, end: String): Response<DirectionResponse> {
        return directionRepository.getRoute(start, end)
    }
}