package com.keepcoding.androidsuperpoderes.data.remote

import com.keepcoding.androidsuperpoderes.data.dto.HeroDTO
import com.keepcoding.androidsuperpoderes.data.dto.LocationDTO

interface RemoteDataSource {
    suspend fun getHeroList(): List<HeroDTO>

    suspend fun getHero(id: String): HeroDTO

    suspend fun getLocations(id: String): Array<LocationDTO>
}
