package com.example.mapstesttask.data.model.directioRespone

import com.google.gson.annotations.SerializedName

data class FeaturesItem(

	@field:SerializedName("geometry")
	val geometry: Geometry
)