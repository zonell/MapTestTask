package com.example.mapstesttask.data.model.pointListResponse

import com.google.gson.annotations.SerializedName

data class PointListResponse(
    @field:SerializedName("ClubNewsStatuses")
	val clubNewsStatuses: List<ClubNewsStatusesItem>
)