package com.keepcoding.androidsuperpoderes.data.remote

import com.keepcoding.androidsuperpoderes.data.dto.HeroDTO
import com.keepcoding.androidsuperpoderes.data.dto.SearchDto

class RemoteDataSourceImpl(
    private val superHeroApi: SuperHeroApi
): RemoteDataSource {
    override suspend fun getHeroList(): List<HeroDTO> = superHeroApi.getHeroList(SearchDto())

    override suspend fun getHero(id: String) = superHeroApi.getHero(SearchDto(name = id))

    override suspend fun getLocations(id: String) = superHeroApi.getHeroLocations(SearchDto(id = id))
}