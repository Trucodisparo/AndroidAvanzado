package com.keepcoding.androidsuperpoderes.components

/**
 * Delegado que gestiona los estados de un componente RangeSelector
 */
class RangeSelectorDelegate (
    private val minValue: Int,
    private val maxValue: Int
){
    var currentBottom = minValue
    var currentTop = maxValue

    fun moveTop(newValue: Int){
        currentTop = if(newValue > maxValue) maxValue
                        else if(newValue <= currentBottom) currentBottom+1
                             else newValue
    }

    fun moveBottom(newValue: Int){
        currentBottom = if(newValue < minValue) minValue
                        else if(newValue >= currentTop) currentTop-1
                             else newValue
    }
}