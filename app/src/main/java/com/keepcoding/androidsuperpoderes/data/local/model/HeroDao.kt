package com.keepcoding.androidsuperpoderes.data.local.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.keepcoding.androidsuperpoderes.data.local.HeroLocal

@Dao
interface HeroDao {

    @Query("SELECT * FROM HeroTable")
    suspend fun getAll(): List<HeroLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(superHero: List<HeroLocal>)

    @Query("SELECT * FROM HeroTable WHERE id=:id")
    suspend fun getHeroById(id: String): HeroLocal

    @Update
    suspend fun updateHero(hero: HeroLocal)
}