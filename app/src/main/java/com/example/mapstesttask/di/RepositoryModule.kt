package com.example.mapstesttask.di

import com.example.mapstesttask.data.repository.direction.DirectionRepository
import com.example.mapstesttask.data.repository.direction.DirectionRepositoryImpl
import com.example.mapstesttask.data.repository.list.ListRepository
import com.example.mapstesttask.data.repository.list.ListRepositoryImpl
import org.koin.dsl.module

/**
 * Created by O.Dziuba on 25.10.2023.
 */

val repositoryModule = module {
    single<ListRepository> { ListRepositoryImpl(get()) }
    single<DirectionRepository> { DirectionRepositoryImpl(get()) }
}