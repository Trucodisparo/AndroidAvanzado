package com.keepcoding.androidsuperpoderes.presentation.heroList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.model.TestDataBuilder
import com.keepcoding.androidsuperpoderes.domain.useCase.GetHeroListUseCase
import com.keepcoding.androidsuperpoderes.test.util.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HeroListViewModelTest{
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getHeroListUseCase: GetHeroListUseCase

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun testCoroutinesTest() = runTest{
        coEvery { getHeroListUseCase.invoke() } returns flow {
            emit(TestDataBuilder()
                .withNumElements(15)
                .build())
            }

        val res = getHeroListUseCase.invoke()
        assertThat(res.first().size, `is`(15))
    }

    @Test
    fun testGetDataFlow() = runTest{
        val heroList = TestDataBuilder()
            .withNumElements(15)
            .build()
        coEvery { getHeroListUseCase.invoke() } returns flow {
            emit(heroList)
        }
        val viewModel = HeroListViewModel(getHeroListUseCase)

        viewModel.heroList.test{
            viewModel.getData()
            assertEquals(HeroListState.IdleState, awaitItem())
            assertEquals(HeroListState.Loading, awaitItem())
            assertEquals(HeroListState.HeroList(heroList), awaitItem())
        }
    }


}