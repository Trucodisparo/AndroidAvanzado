package com.keepcoding.androidsuperpoderes.data.dto

import com.squareup.moshi.Json

data class LocationDTO (
    @Json(name = "id") val id:String?,
    @Json(name = "longitud") val longitude:String?,
    @Json(name = "dateShow") val dateShow:String?,
    @Json(name = "latitud") val latitude:String?,
    @Json(name = "hero") val hero: HeroIDDto?
)