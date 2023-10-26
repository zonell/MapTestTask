package com.example.mapstesttask.data.useCase.list

import com.example.mapstesttask.data.model.pointListResponse.PointListResponse
import com.example.mapstesttask.data.repository.list.ListRepository
import retrofit2.Response

/**
 * Created by O.Dziuba on 25.10.2023.
 */
class PointListUseCaseImpl(
    private val listRepository: ListRepository
) : PointListUseCase {

    override suspend fun getPointList(): Response<PointListResponse> {
        return listRepository.getPointList()
    }

}