package com.keepcoding.androidsuperpoderes.data.local

import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RoomDatabase
import com.keepcoding.androidsuperpoderes.data.local.model.HeroDao

@Database(entities = [HeroLocal::class], version = 1, exportSchema = false)
abstract class HeroDataBase: RoomDatabase() {
    abstract fun heroDao(): HeroDao
}