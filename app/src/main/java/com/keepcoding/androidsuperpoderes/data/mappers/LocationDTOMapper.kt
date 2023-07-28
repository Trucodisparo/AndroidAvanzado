package com.keepcoding.androidsuperpoderes.data.mappers

import com.keepcoding.androidsuperpoderes.data.dto.LocationDTO
import com.keepcoding.androidsuperpoderes.domain.model.LocationModel

fun LocationDTO.toLocationModel() = LocationModel(
    id = id ?: "",
    longitude = longitude?.toDouble() ?: 0.0,
    latitude = latitude?.toDouble() ?: 0.0,
    dateShow = dateShow ?: "",
    heroId = hero?.id ?: ""
)