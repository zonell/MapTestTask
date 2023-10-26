package com.example.mapstesttask.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mapstesttask.data.model.pointListResponse.ClubNewsStatusesItem
import com.example.mapstesttask.data.network.NetworkResponse
import com.example.mapstesttask.data.useCase.list.PointListUseCase
import kotlinx.coroutines.launch

class ListViewModel(
    private val pointListUseCase: PointListUseCase
) : ViewModel() {

    private val _pointList = MutableLiveData<NetworkResponse<List<ClubNewsStatusesItem>>>()
    val pointList: LiveData<NetworkResponse<List<ClubNewsStatusesItem>>> get() = _pointList

    init {
        viewModelScope.launch {
            kotlin.runCatching {
                pointListUseCase.getPointList()
            }.onSuccess {
                if (it.isSuccessful) {
                    it.body()?.let { response ->
                        _pointList.value = NetworkResponse.Success(response.clubNewsStatuses)
                    }
                }
            }.onFailure {
                _pointList.value = NetworkResponse.Failure(it)
            }
        }
    }
}