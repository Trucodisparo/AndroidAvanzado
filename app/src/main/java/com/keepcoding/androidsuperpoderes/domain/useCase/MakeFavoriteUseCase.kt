package com.keepcoding.androidsuperpoderes.domain.useCase

import com.keepcoding.androidsuperpoderes.data.HeroRepository
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel

class MakeFavoriteUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke(hero: HeroModel): Boolean = heroRepository.switchFavorite(hero)
}