package com.keepcoding.androidsuperpoderes.data.remote

import com.keepcoding.androidsuperpoderes.data.dto.HeroDTO
import com.keepcoding.androidsuperpoderes.data.dto.LocationDTO
import com.keepcoding.androidsuperpoderes.data.dto.SearchDto
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

const val TOKEN = "eyJraWQiOiJwcml2YXRlIiwiYWxnIjoiSFMyNTYiLCJ0eXAiOiJKV1QifQ.eyJlbWFpbCI6ImJlamxAa2VlcGNvZGluZy5lcyIsImlkZW50aWZ5IjoiN0FCOEFDNEQtQUQ4Ri00QUNFLUFBNDUtMjFFODRBRThCQkU3IiwiZXhwaXJhdGlvbiI6NjQwOTIyMTEyMDB9.WOnEGKkNdQs4yRM7GWU9pdj0lKtpesN7TCTO3WYWt9E"
interface SuperHeroApi {

    @POST("api/heros/all")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getHeroList(@Body searchDto: SearchDto): List<HeroDTO>

    @POST("api/heros/all")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getHero(@Body searchDto: SearchDto): HeroDTO

    @POST("api/heros/locations")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getHeroLocations(@Body searchDto: SearchDto): Array<LocationDTO>

}