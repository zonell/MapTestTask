package com.example.mapstesttask.app

import android.app.Application
import com.example.mapstesttask.BuildConfig
import com.example.mapstesttask.di.networkModule
import com.example.mapstesttask.di.repositoryModule
import com.example.mapstesttask.di.useCaseModule
import com.example.mapstesttask.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

/**
 * Created by O.Dziuba on 25.10.2023.
 */
class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            module {
                androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
                androidContext(this@Application)
                modules(
                    listOf(
                        viewModelModule,
                        useCaseModule,
                        repositoryModule,
                        networkModule
                    )
                )
            }
        }
    }
}