package com.example.mapstesttask.data.network

sealed class NetworkResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResponse<T>()
    data class Failure(val throwable: Throwable) : NetworkResponse<Nothing>()
}