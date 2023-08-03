package com.keepcoding.androidsuperpoderes.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.androidsuperpoderes.data.dto.HeroDTO
import com.keepcoding.androidsuperpoderes.data.dto.LocationDTO
import com.keepcoding.androidsuperpoderes.data.dto.SearchDto
import com.keepcoding.androidsuperpoderes.test.util.DefaultDispatcherRule
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.keepcoding.androidsuperpoderes.di.baseUrl
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.Matchers.greaterThan
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.greaterThanOrEqualTo
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.Matchers.`is`
import org.junit.Test

@ExperimentalCoroutinesApi
class SuperHeroApiTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    private lateinit var api: SuperHeroApi

    @Before
    fun setup(){
        api = retrofit.create(SuperHeroApi::class.java)
    }

    @Test
    fun `WHEN request hero list EXPECT result`() = runTest {
        val result = api.getHeroList(SearchDto())
        assertThat(result, notNullValue())
        assertThat(result.size, `greaterThan`(0))
    }

    @Test
    fun `WHEN request hero EXPECT result`() = runTest {
        val result = api.getHero(SearchDto(name="Goku"))
        assertThat(result, instanceOf(List::class.java))
        assertThat(result.size, `is`(1))
    }

    @Test
    fun `WHEN request location list EXPECT result`() = runTest {
        val result = api.getHeroLocations(SearchDto(id="81D51BD2-E82C-4E1D-8216-BDFB107C1F28"))
        assertThat(result, instanceOf(Array<LocationDTO>::class.java))
    }

    companion object{
        private lateinit var retrofit: Retrofit

        @BeforeClass
        @JvmStatic
        fun setupCommon() {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                                .apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                }).build()
                )
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .addLast(KotlinJsonAdapterFactory())
                            .build()
                    )
                ).build()
        }
    }
}