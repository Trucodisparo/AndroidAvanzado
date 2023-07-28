package com.keepcoding.androidsuperpoderes.presentation.detail

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.useCase.GetDetailUseCase
import com.keepcoding.androidsuperpoderes.domain.useCase.GetHeroListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HeroDetailViewModel(
    private val getDetailUseCase: GetDetailUseCase
    ): ViewModel() {
        private var _hero = MutableLiveData<HeroModel>()
        val hero: LiveData<HeroModel> get() = _hero

        private var _errorMsg = MutableLiveData<String?>()
        val errorMsg: LiveData<String?> get() = _errorMsg

        fun getData(id: String){
            //Scope
            viewModelScope.launch{
                try {
                    val result = withContext(Dispatchers.IO) {
                        getDetailUseCase.invoke(id)
                    }
                    _hero.postValue(result)
                    _errorMsg.postValue(null)
                }catch(t: Throwable){
                    _errorMsg.postValue(t.toString())
                    Log.d("LIST_ERROR", t.toString())
                }
            }
        }
    }
