package com.keepcoding.androidsuperpoderes.domain.useCase

import com.keepcoding.androidsuperpoderes.data.HeroRepository
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel

class GetHeroListUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke(filter: Boolean = false, search: String = "") = heroRepository.getHeroList(filter, search)

}