package com.keepcoding.androidsuperpoderes.presentation.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.keepcoding.androidsuperpoderes.domain.model.TestDataBuilder
import com.keepcoding.androidsuperpoderes.presentation.heroList.ShowHero
import org.koin.androidx.compose.koinViewModel

@Composable
fun HeroDetailScreen(
    id: String,
    vm: HeroDetailViewModel = koinViewModel()
) {
    val heroState = vm.hero.observeAsState()
    val errorState = vm.errorMsg.observeAsState()
    vm.getData(id)

    errorState.value?.let{
        Text(errorState.value ?: "Se ha producido un error")
    } ?: run{
        heroState.value?.let{hero ->
            ShowHero(hero = hero)
        } ?: run{
            Text("Cargando")
        }
    }

}