package com.keepcoding.androidsuperpoderes.di

import com.keepcoding.androidsuperpoderes.presentation.*
import com.keepcoding.androidsuperpoderes.presentation.detail.HeroDetailScreen
import com.keepcoding.androidsuperpoderes.presentation.detail.HeroDetailViewModel
import com.keepcoding.androidsuperpoderes.presentation.heroList.HeroListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module{
    viewModel{ HeroListViewModel(get(), get()) }
    viewModel{ HeroDetailViewModel(get()) }

    //viewModelOf(::HeroListViewModel) Apparently not needed? idk
}