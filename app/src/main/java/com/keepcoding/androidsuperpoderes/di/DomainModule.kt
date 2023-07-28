package com.keepcoding.androidsuperpoderes.di

import com.keepcoding.androidsuperpoderes.domain.useCase.GetDetailUseCase
import com.keepcoding.androidsuperpoderes.domain.useCase.GetDistanceFromHeroUseCase
import com.keepcoding.androidsuperpoderes.domain.useCase.GetHeroListUseCase
import com.keepcoding.androidsuperpoderes.domain.useCase.MakeFavoriteUseCase
import org.koin.dsl.module

val domainModule  = module {

    single { GetHeroListUseCase(get()) }

    single {GetDetailUseCase(get())}

    single {MakeFavoriteUseCase(get())}

    single {GetDistanceFromHeroUseCase()}
}