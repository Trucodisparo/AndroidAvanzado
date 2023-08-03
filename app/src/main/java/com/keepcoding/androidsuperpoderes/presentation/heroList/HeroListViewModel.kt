package com.keepcoding.androidsuperpoderes.presentation.heroList

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.androidsuperpoderes.FlowExercises
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.useCase.GetHeroListUseCase
import com.keepcoding.androidsuperpoderes.presentation.detail.HeroDetailState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HeroListViewModel(
    val getHeroListUseCase: GetHeroListUseCase
    ): ViewModel() {
        private var _heroList = MutableStateFlow<HeroListState>(HeroListState.IdleState)
        val heroList: StateFlow<HeroListState> get() = _heroList

        private var _errorMsg = MutableLiveData<String?>()
        val errorMsg: LiveData<String?> get() = _errorMsg

        fun getData(filter: Boolean = false, search: String = ""){
            //Scope
            viewModelScope.launch{
                _heroList.value = HeroListState.Loading
                try {
                    withContext(Dispatchers.IO) {
                        getHeroListUseCase.invoke(filter, search).collect{_heroList.value = HeroListState.HeroList(it)}
                    }
                    _errorMsg.postValue(null)
                }catch(t: Throwable){
                    _errorMsg.postValue(t.toString())
                    Log.d("LIST_ERROR", t.toString())
                }
            }
        }
    }
