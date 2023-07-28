package com.keepcoding.androidsuperpoderes.domain.useCase

import com.keepcoding.androidsuperpoderes.data.HeroRepository

class GetDetailUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke(id: String) = heroRepository.getHero(id)
}