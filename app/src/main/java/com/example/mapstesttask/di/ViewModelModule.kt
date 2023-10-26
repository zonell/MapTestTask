package com.example.mapstesttask.di

import com.example.mapstesttask.ui.list.ListViewModel
import com.example.mapstesttask.ui.map.MapViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by O.Dziuba on 25.10.2023.
 */
val viewModelModule = module {
    viewModel { ListViewModel(get()) }
    viewModel { MapViewModel(get()) }
}