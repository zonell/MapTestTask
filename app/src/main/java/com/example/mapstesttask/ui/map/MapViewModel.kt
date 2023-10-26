package com.example.mapstesttask.ui.map

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mapstesttask.data.network.NetworkResponse
import com.example.mapstesttask.data.useCase.direction.DirectionUseCase
import kotlinx.coroutines.launch
import org.osmdroid.util.GeoPoint

class MapViewModel(
    private val directionUseCase: DirectionUseCase
) : ViewModel() {

    private val kiev = "50.4501, 30.5234"
    private val kharkiv = "49.9935, 36.2304"

    private val _directionLD = MutableLiveData<NetworkResponse<List<GeoPoint>>>()
    val directionLD: LiveData<NetworkResponse<List<GeoPoint>>> get() = _directionLD

    fun getRoad() {
        viewModelScope.launch {
            kotlin.runCatching {
                directionUseCase.getRoute(kiev, kharkiv)
            }.onSuccess { response ->
                if (response.isSuccessful) {
                    response.body()?.features?.firstOrNull()?.geometry?.let {
                        _directionLD.value = NetworkResponse.Success(DirectionMapper.mapToGeoPoint(it.coordinates))
                    }
                }
            }.onFailure {
                Log.e("!@#!@#", "Error: ${it.message}")
                _directionLD.value = NetworkResponse.Failure(it)
            }
        }
    }
}