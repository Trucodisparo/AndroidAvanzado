package com.keepcoding.androidsuperpoderes.data.local

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getHeroList() : List<HeroLocal>
    suspend fun insertHeroList(heroList: List<HeroLocal>)
    suspend fun getHero(id: String): Flow<HeroLocal>
    suspend fun updateHero(hero: HeroLocal)
}