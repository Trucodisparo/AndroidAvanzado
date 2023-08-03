package com.keepcoding.androidsuperpoderes.data.local

import com.keepcoding.androidsuperpoderes.data.local.model.HeroDao
import kotlinx.coroutines.flow.flow

class LocalDataSourceImpl(
    private val heroDao: HeroDao
) :LocalDataSource {
    override suspend fun getHeroList() = heroDao.getAll()

    override suspend fun insertHeroList(heroList: List<HeroLocal>) = heroDao.insertAll(heroList)

    override suspend fun getHero(id: String) = flow{
        emit(heroDao.getHeroById(id))
    }

    override suspend fun updateHero(hero: HeroLocal) = heroDao.updateHero(hero)
}