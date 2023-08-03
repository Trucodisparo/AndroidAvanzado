package com.keepcoding.androidsuperpoderes.domain.useCase

import com.keepcoding.androidsuperpoderes.data.HeroRepository
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import kotlinx.coroutines.flow.Flow

class GetHeroListUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke(filter: Boolean = false, search: String = ""): Flow<List<HeroModel>> = heroRepository.getHeroList(filter, search)

}