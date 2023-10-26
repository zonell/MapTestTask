package com.example.mapstesttask.di

import com.example.mapstesttask.data.useCase.direction.DirectionUseCase
import com.example.mapstesttask.data.useCase.direction.DirectionUseCaseImpl
import com.example.mapstesttask.data.useCase.list.PointListUseCase
import com.example.mapstesttask.data.useCase.list.PointListUseCaseImpl
import org.koin.dsl.module

/**
 * Created by O.Dziuba on 25.10.2023.
 */
val useCaseModule = module {
    single<PointListUseCase> { PointListUseCaseImpl(get()) }
    single<DirectionUseCase> { DirectionUseCaseImpl(get()) }
}