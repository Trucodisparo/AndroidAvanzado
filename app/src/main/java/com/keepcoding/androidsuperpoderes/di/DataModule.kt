package com.keepcoding.androidsuperpoderes.di

import android.content.Context
import androidx.room.Room
import com.keepcoding.androidsuperpoderes.data.HeroRepository
import com.keepcoding.androidsuperpoderes.data.HeroRepositoryImpl
import com.keepcoding.androidsuperpoderes.data.local.HeroDataBase
import com.keepcoding.androidsuperpoderes.data.local.LocalDataSource
import com.keepcoding.androidsuperpoderes.data.local.LocalDataSourceImpl
import com.keepcoding.androidsuperpoderes.data.remote.RemoteDataSource
import com.keepcoding.androidsuperpoderes.data.remote.RemoteDataSourceImpl
import com.keepcoding.androidsuperpoderes.data.remote.SuperHeroApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val baseUrl = "https://dragonball.keepcoding.education/"

val dataModule = module {

    single{
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT ).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit>{
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi>{
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }
    single<HeroRepository> { HeroRepositoryImpl(get(), get()) }

    single<RemoteDataSource>{ RemoteDataSourceImpl(get()) }

    single<LocalDataSource>{ LocalDataSourceImpl(get()) }

    single{ getSuperHeroApi(get()) }

    single{ getDatabase(get()) }

    single{ provideHeroDao(get()) }

}

private fun getSuperHeroApi(retrofit: Retrofit) : SuperHeroApi = retrofit.create(SuperHeroApi::class.java)

private fun getDatabase(context: Context) : HeroDataBase= Room.databaseBuilder(
                                                    context,
                                                    HeroDataBase::class.java, "superhero-db"
                                            ).build()

private fun provideHeroDao(db: HeroDataBase) = db.heroDao()