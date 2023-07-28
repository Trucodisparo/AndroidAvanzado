package com.keepcoding.androidsuperpoderes.domain.model

data class HeroModel(
    val id: String,
    val name: String,
    val photoUrl: String,
    val favorite: Boolean,
    val description: String,
    val location: LocationModel = LocationModel()
)
