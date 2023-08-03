package com.keepcoding.androidsuperpoderes

import android.util.Log
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.withIndex
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//Changed for git feature branch

class FlowExercises {
    val list = listOf(1,2,3,4,5)
    val mList = mutableListOf<HeroModel>()

    suspend fun sumList(): Int{
        var sum = list.asFlow().fold(0){
                accum, i -> accum + i
        }

        return sum
    }

    suspend fun firstTwo(list: List<HeroModel>){
        val filteredList = list.asFlow().filter{ hero ->
            hero.name.length % 2 != 0
        }.take(2).toList()
        Log.d("FLOW_EXERCISES", "Bienvenidos, ${filteredList[0].name} y ${filteredList[1].name}")

        val str = list.asFlow().filter{ hero ->
            hero.name.length % 2 != 0
        }.take(2).fold("Bienvenidos, "){
            accum, i -> accum + "${i.name} y "
        }.dropLast(3)
        Log.d("FLOW_EXERCISES", str)

        val str2 = list.asFlow().filter{ hero ->
            hero.name.length % 2 != 0
        }.take(2).withIndex().fold("Bienvenidos, "){
                accum, i -> if(i.index == 0) accum + "${i.value.name} y "
            else accum + i.value.name
        }
        Log.d("FLOW_EXERCISES", str2)
    }

    suspend fun prueba(){
        val flow = flow{emit(listOf(1,2,3,4))
            emit(listOf(5,6,7,8))}
        flow.collect{Log.d("PRUEBAFLOWS", it.toString())}
    }
}