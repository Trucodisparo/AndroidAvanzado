package com.keepcoding.androidsuperpoderes.presentation.detail

import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.model.TestDataBuilder

sealed class HeroDetailState{
    object IdleState : HeroDetailState()
    object Loading : HeroDetailState()
    data class Hero(val hero: HeroModel) : HeroDetailState()
}

val testObject = HeroDetailState.IdleState
val testDataClass = HeroDetailState.Hero(TestDataBuilder().buildSingle())