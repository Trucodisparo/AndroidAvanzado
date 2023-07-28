package com.keepcoding.androidsuperpoderes.domain.useCase;

import com.keepcoding.androidsuperpoderes.domain.model.LocationModel
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.pow

class GetDistanceFromHeroUseCase {

    private val EARTH_RADIUS: Int = 6371

    fun invoke(coord1: LocationModel, coord2: LocationModel): Double {

        val lat1 = Math.toRadians(coord1.latitude)
        val lon1 = Math.toRadians(coord1.longitude)
        val lat2 = Math.toRadians(coord2.latitude)
        val lon2 = Math.toRadians(coord2.longitude)

        val dLat = lat2 - lat1
        val dLon = lon2 - lon1

        val a = sin(dLat / 2).pow(2) + cos(lat1) * cos(lat2) * sin(dLon / 2).pow(2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))

        return EARTH_RADIUS * c
    }
}