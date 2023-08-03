package com.keepcoding.androidsuperpoderes.presentation.detail

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.androidsuperpoderes.FlowExercises
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.useCase.GetDetailUseCase
import com.keepcoding.androidsuperpoderes.domain.useCase.GetHeroListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HeroDetailViewModel(
    private val getDetailUseCase: GetDetailUseCase
    ): ViewModel() {
        private var _hero = MutableStateFlow<HeroDetailState>(HeroDetailState.IdleState)
        val hero: StateFlow<HeroDetailState> get() = _hero

        private var _errorMsg = MutableLiveData<String?>()
        val errorMsg: LiveData<String?> get() = _errorMsg

        fun getData(id: String){
            //Scope
            viewModelScope.launch{
                try {
                    _hero.value = HeroDetailState.Loading
                    withContext(Dispatchers.IO) {
                        getDetailUseCase.invoke(id).collect{
                            _hero.value = HeroDetailState.Hero(it)
                        }
                    }
                    _errorMsg.postValue(null)
                }catch(t: Throwable){
                    _errorMsg.postValue(t.toString())
                    Log.d("LIST_ERROR", t.toString())
                }
            }
        }
    }
