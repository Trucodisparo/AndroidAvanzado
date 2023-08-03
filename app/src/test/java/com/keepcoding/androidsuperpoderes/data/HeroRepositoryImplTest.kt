package com.keepcoding.androidsuperpoderes.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.androidsuperpoderes.data.dto.HeroDTO
import com.keepcoding.androidsuperpoderes.data.local.HeroLocal
import com.keepcoding.androidsuperpoderes.data.local.LocalDataSourceImpl
import com.keepcoding.androidsuperpoderes.data.remote.RemoteDataSourceImpl
import com.keepcoding.androidsuperpoderes.test.util.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HeroRepositoryImplTest{
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var localDataSource: LocalDataSourceImpl

    @MockK(relaxed = true)
    private lateinit var remoteDataSource: RemoteDataSourceImpl

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN get hero list EXPECT list from LocalData`() = runTest{
        coEvery { localDataSource.getHeroList() } returns
            listOf<HeroLocal>(
                HeroLocal("id", "name", "url", true, "description"),
                HeroLocal("id", "name", "url", true, "description")
            )
        coEvery { remoteDataSource.getHeroList() } returns listOf<HeroDTO>()

        val repository = HeroRepositoryImpl(remoteDataSource, localDataSource)
        val result = repository.getHeroList(false, "")
        assertThat(result, instanceOf(Flow::class.java))
        assertThat(result.first().size, `is`(2))
    }

    @Test
    fun `WHEN get hero list EXPECT list from RemoteData`() = runTest{
        coEvery { localDataSource.getHeroList() } returns
                listOf<HeroLocal>()
        coEvery { remoteDataSource.getHeroList() } returns listOf<HeroDTO>(
            HeroDTO("id", "name", "url", "description", true),
            HeroDTO("id", "name", "url", "description", true)
        )

        val repository = HeroRepositoryImpl(remoteDataSource, localDataSource)
        val result = repository.getHeroList(false, "")
        assertThat(result, instanceOf(Flow::class.java))
        assertThat(result.first().size, `is`(2))
    }

}