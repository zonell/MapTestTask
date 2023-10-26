package com.example.mapstesttask.data.model.directioRespone

import com.google.gson.annotations.SerializedName

data class Geometry(

	@field:SerializedName("coordinates")
	val coordinates: List<List<Double>>
)