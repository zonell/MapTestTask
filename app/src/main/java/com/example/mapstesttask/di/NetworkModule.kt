package com.example.mapstesttask.di

import com.example.mapstesttask.BuildConfig
import com.example.mapstesttask.data.network.ApiNetwork
import com.example.mapstesttask.data.network.NetworkManager
import com.example.mapstesttask.data.network.NetworkManagerImpl
import com.example.mapstesttask.data.network.MapNetwork
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by O.Dziuba on 25.10.2023.
 */

private const val HTTP_LOGGING_INTERCEPTOR = "http_logging_interceptor"
private const val TIMEOUT_SEC: Long = 60

private const val BASE_API: String = "base_api"
private const val MAP_API: String = "map_api"

val networkModule = module {

    single<Interceptor>(named(HTTP_LOGGING_INTERCEPTOR)) {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
    }

    single {
        OkHttpClient
            .Builder()
            .addInterceptor(get<Interceptor>(named(HTTP_LOGGING_INTERCEPTOR)))
            .connectTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)
            .build()
    }

    single(named(BASE_API)) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            )
            .build()
    }

    single(named(MAP_API)) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.MAP_URL)
            .client(get())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            )
            .build()
    }

    single(named(BASE_API)) {
        (get(named(BASE_API)) as Retrofit).create(ApiNetwork::class.java)
    }

    single(named(MAP_API)) {
        (get(named(MAP_API)) as Retrofit).create(MapNetwork::class.java)
    }

    single<NetworkManager> { NetworkManagerImpl(get(named(BASE_API)), get(named(MAP_API))) }
}