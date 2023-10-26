package com.example.mapstesttask.data.model.directioRespone

import com.google.gson.annotations.SerializedName

data class DirectionResponse(

	@field:SerializedName("features")
	val features: List<FeaturesItem>,
)