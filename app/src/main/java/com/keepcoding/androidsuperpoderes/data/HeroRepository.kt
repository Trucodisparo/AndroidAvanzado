package com.keepcoding.androidsuperpoderes.data

import com.keepcoding.androidsuperpoderes.domain.model.HeroModel

interface HeroRepository {
    suspend fun getHeroList(filter: Boolean, search: String): List<HeroModel>
    suspend fun getHero(id: String): HeroModel
    suspend fun switchFavorite(hero: HeroModel): Boolean
}