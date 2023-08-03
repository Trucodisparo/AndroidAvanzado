package com.keepcoding.androidsuperpoderes.domain.model

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.Matchers.`is`
import org.junit.Test

class HeroModelTest{
    private val heroModel = HeroModel("id", "name", "url", true, "description")

    @Test
    fun `WHEN constructed EXPECT noexcept`(){
        assertThat(heroModel, instanceOf(HeroModel::class.java))
    }

    @Test
    fun `WHEN constructed EXPECT id = 'id'`(){
        assertThat(heroModel.id, `is`("id"))
    }

    @Test
    fun `WHEN constructed EXPECT name = 'name'`(){
        assertThat(heroModel.name, `is`("name"))
    }

    @Test
    fun `WHEN constructed EXPECT photoUrl = 'url`(){
        assertThat(heroModel.photoUrl, `is`("url"))
    }

    @Test
    fun `WHEN constructed EXPECT favorite = true`(){
        assertThat(heroModel.favorite, `is`(true))
    }

    @Test
    fun `WHEN constructed EXPECT description = 'description'`(){
        assertThat(heroModel.description, `is`("description"))
    }

    @Test
    fun `WHEN constructed EXPECT default location = LocationModel()`(){
        assertThat(heroModel.location, `is`(LocationModel()))
    }

    @Test
    fun `WHEN constructed EXPECT location = locationModel`(){
        val locationModel = LocationModel(longitude = 2.0, latitude = 3.0)
        val heroModel2 = HeroModel(heroModel.id, heroModel.name, heroModel.photoUrl, heroModel.favorite, heroModel.description, locationModel)
        assertThat(heroModel2.location, `is`(locationModel))
    }

}