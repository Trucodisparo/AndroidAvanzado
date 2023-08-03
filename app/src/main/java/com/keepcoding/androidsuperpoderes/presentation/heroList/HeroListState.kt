package com.keepcoding.androidsuperpoderes.presentation.heroList

import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.model.TestDataBuilder

sealed class HeroListState {
    object IdleState : HeroListState()
    object Loading : HeroListState()
    data class HeroList(val heroList: List<HeroModel>) : HeroListState()
}

val testObject = HeroListState.IdleState
val testDataClass = HeroListState.HeroList(TestDataBuilder().build())

/** Más flexibilidad de cara a controlar estados:
    data class HeroListState(
        var isLoaded: Boolean = false,
        var list: List<HeroModel>? = null,
        var isError: Boolean = false,
        var errorDetail: String? = null
    )
 */