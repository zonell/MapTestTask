package com.example.mapstesttask.ui.map

import org.osmdroid.util.GeoPoint

/**
 * Created by O.Dziuba on 26.10.2023.
 */
class DirectionMapper {
    companion object {
        fun mapToGeoPoint(list: List<List<Double>>): List<GeoPoint> {
            val listGeo = mutableListOf<GeoPoint>()
            list.forEach {
                listGeo.add(GeoPoint(it.first(), it.last()))
            }
            return listGeo
        }
    }
}