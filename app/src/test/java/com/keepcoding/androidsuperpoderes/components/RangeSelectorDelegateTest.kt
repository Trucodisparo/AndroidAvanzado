package com.keepcoding.androidsuperpoderes.components

import org.hamcrest.Matchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class RangeSelectorDelegateTest{
    private val rangeSelectorDelegate = RangeSelectorDelegate(40,80)

    @Test
    fun `WHEN moveBottom EXPECT bottom is currentTop - 1`(){
        rangeSelectorDelegate.moveBottom(90)
        assertThat(rangeSelectorDelegate.currentBottom, `is`(rangeSelectorDelegate.currentTop - 1))
    }

    @Test
    fun `WHEN moveTop EXPECT top is currentBottom + 1`(){
        rangeSelectorDelegate.moveTop(10)
        assertThat(rangeSelectorDelegate.currentTop, `is`(rangeSelectorDelegate.currentBottom + 1))
    }

    @Test
    fun `WHEN moveBottom EXPECT bottom is minValue`(){
        rangeSelectorDelegate.moveBottom(20)
        assertThat(rangeSelectorDelegate.currentBottom, `is`(40))
    }

    @Test
    fun `WHEN moveTop EXPECT top is maxValue`(){
        rangeSelectorDelegate.moveTop(90)
        assertThat(rangeSelectorDelegate.currentTop, `is`(80))
    }

    @Test
    fun `WHEN moveTop EXPECT top is OK`(){
        rangeSelectorDelegate.moveTop(50)
        assertThat(rangeSelectorDelegate.currentTop, `is`(50))
    }

    @Test
    fun `WHEN moveBottom EXPECT bottom is OK`(){
        rangeSelectorDelegate.moveBottom(45)
        assertThat(rangeSelectorDelegate.currentBottom, `is`(45))
    }

    @Test
    fun `WHEN moveTop back EXPECT top is OK`(){
        rangeSelectorDelegate.moveTop(80)
        assertThat(rangeSelectorDelegate.currentTop, `is`(80))
    }

    @Test
    fun `WHEN moveBottom back EXPECT bottom is OK`(){
        rangeSelectorDelegate.moveBottom(40)
        assertThat(rangeSelectorDelegate.currentBottom, `is`(40))
    }
}