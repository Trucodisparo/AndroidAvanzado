package com.keepcoding.androidsuperpoderes.data.local

interface LocalDataSource {

    suspend fun getHeroList() : List<HeroLocal>
    suspend fun insertHeroList(heroList: List<HeroLocal>)
    suspend fun getHero(id: String): HeroLocal
    suspend fun updateHero(hero: HeroLocal)
}