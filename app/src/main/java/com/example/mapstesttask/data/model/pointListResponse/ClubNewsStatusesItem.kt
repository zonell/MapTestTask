package com.example.mapstesttask.data.model.pointListResponse

import com.google.gson.annotations.SerializedName

data class ClubNewsStatusesItem(

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("title")
	val title: String
)