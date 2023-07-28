package com.keepcoding.androidsuperpoderes.presentation.heroList

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.keepcoding.androidsuperpoderes.domain.model.TestDataBuilder
import com.keepcoding.androidsuperpoderes.ui.theme.AndroidSuperPoderesTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun HeroListScreen(
    vm: HeroListViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
){
    val state = vm.heroList.observeAsState()
    val errorState = vm.errorMsg.observeAsState()

    Box(modifier = Modifier.fillMaxSize()){
        if(errorState.value == null) {
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
                    val heros = state.value ?: emptyList()
                    items(heros.size) {
                        val hero = heros[it]
                        ShowHero(hero) {
                            onItemClick.invoke(hero.id)
                        }
                    }
                }
            }
        }else{
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Text(errorState.value ?: "Se ha producido un error")
            }
        }
    }
}

@Preview
@Composable
fun HeroListPreview(){
    AndroidSuperPoderesTheme(){
        HeroListScreen{
            //empty callback
        }
    }
}