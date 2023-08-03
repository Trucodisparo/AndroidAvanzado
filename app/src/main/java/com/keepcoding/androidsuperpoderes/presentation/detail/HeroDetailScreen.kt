package com.keepcoding.androidsuperpoderes.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.keepcoding.androidsuperpoderes.domain.model.TestDataBuilder
import com.keepcoding.androidsuperpoderes.navigation.Screen
import com.keepcoding.androidsuperpoderes.presentation.heroList.ShowHero
import org.koin.androidx.compose.koinViewModel

@Composable
fun HeroDetailScreen(
    id: String,
    vm: HeroDetailViewModel = koinViewModel(),
    onBackClick: () -> Unit
) {
    val heroState = vm.hero.collectAsStateWithLifecycle()
    val errorState = vm.errorMsg.observeAsState()
    vm.getData(id)
    /*
    errorState.value?.let{
        Text(errorState.value ?: "Se ha producido un error")
    } ?: run{
        heroState.value?.let{hero ->
            ShowHero(hero = hero, 0)
        } ?: run{
            Text("Cargando")
        }
    }*/

    when(heroState.value){
        is HeroDetailState.IdleState -> {}
        is HeroDetailState.Loading -> {}
        is HeroDetailState.Hero -> {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = onBackClick) {
                        Text("Atrás")
                    }
                }
                ShowHero(hero = (heroState.value as HeroDetailState.Hero).hero, 0)
            }
        }
    }

}