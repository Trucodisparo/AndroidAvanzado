package com.keepcoding.androidsuperpoderes.data

import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import kotlinx.coroutines.flow.Flow

interface HeroRepository {
    suspend fun getHeroList(filter: Boolean, search: String): Flow<List<HeroModel>>
    suspend fun getHero(id: String): Flow<HeroModel>
    suspend fun switchFavorite(hero: HeroModel): Boolean
}