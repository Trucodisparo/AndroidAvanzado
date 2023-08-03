package com.keepcoding.androidsuperpoderes.presentation.heroList

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.model.TestDataBuilder
import com.keepcoding.androidsuperpoderes.ui.theme.AndroidSuperPoderesTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.withIndex
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.compose.koinViewModel

@Composable
fun HeroListScreen(
    vm: HeroListViewModel = koinViewModel(),
    onItemClick: (String) -> Unit,
){
    vm.getData()
    val state = vm.heroList.collectAsStateWithLifecycle()
    val errorState = vm.errorMsg.observeAsState()

    when(state.value) {
        is HeroListState.HeroList -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(255, 139, 61))
            ) {
                if (errorState.value == null) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            "Listado de Héroes",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp)
                        )
                        LazyColumn(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            val heros = (state.value as HeroListState.HeroList).heroList
                            items(heros.size) {
                                val hero = heros[it]
                                ShowHero(hero, it) {
                                    onItemClick.invoke(hero.id)
                                }
                            }
                        }
                    }
                } else {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(errorState.value ?: "Se ha producido un error")
                    }
                }
            }
        }
        is HeroListState.IdleState -> {}
        is HeroListState.Loading -> {}
    }
}

@Preview
@Composable
fun HeroListPreview(){
    AndroidSuperPoderesTheme(){
        HeroListScreen(koinViewModel(), {})
    }
}