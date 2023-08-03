package com.keepcoding.androidsuperpoderes.data

import android.util.Log
import com.keepcoding.androidsuperpoderes.data.dto.LocationDTO
import com.keepcoding.androidsuperpoderes.data.local.HeroLocal
import com.keepcoding.androidsuperpoderes.data.local.LocalDataSource
import com.keepcoding.androidsuperpoderes.data.mappers.toLocationModel
import com.keepcoding.androidsuperpoderes.data.remote.RemoteDataSource
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.model.LocationModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import toHeroLocal
import toHeroModel

class HeroRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): HeroRepository {

    override suspend fun getHeroList(filter: Boolean, search: String): Flow<List<HeroModel>>{
        var localData = localDataSource.getHeroList()
        return if(localData.isNotEmpty()){
            if(filter) localData = filterFavorites(localData)
            if(search.isNotBlank()) localData = filterSearch(localData, search)
            val result = localData.map{it.toHeroModel()}
            flow{emit(result)}
        }else{
            val remoteData = remoteDataSource.getHeroList().filter{
                it.id?.isNotEmpty() == true
            }
            localDataSource.insertHeroList(remoteData.map{it.toHeroLocal()})
            flow{emit(remoteData.map{it.toHeroModel()})}
        }
    }

    private fun filterFavorites(list: List<HeroLocal>): List<HeroLocal>{
        return list.filter{it.favorite }
    }

    override suspend fun getHero(id: String): Flow<HeroModel> {
        return try{
            val heroModel = localDataSource.getHero(id).map{it.toHeroModel()}
            val location = getLocation(id)
            heroModel.map{
                HeroModel(it.id, it.name, it.photoUrl, it.favorite, it.description, location)
            }
        }catch(t: Throwable){
            flow{
                emit(remoteDataSource.getHero(id).toHeroModel())
            }
        }
    }

     private suspend fun getLocation(id: String): LocationModel {
         val locations = remoteDataSource.getLocations(id)
         return if(locations.isEmpty()) LocationModel()
         else locations.last().toLocationModel()
    }

    override suspend fun switchFavorite(hero: HeroModel): Boolean{
        val updatedHero = HeroLocal(hero.id, hero.name, hero.photoUrl, !hero.favorite, hero.description)
        return try {
            localDataSource.updateHero(updatedHero)
            true
        }catch(t: Throwable){
            false
        }
    }

    private fun filterSearch(list: List<HeroLocal>, search: String): List<HeroLocal>{
        return list.filter{it.name.startsWith(search, true)}
    }
}