package com.keepcoding.androidsuperpoderes.presentation.heroList

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.useCase.GetHeroListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HeroListViewModel(
    val context: Context,
    val getHeroListUseCase: GetHeroListUseCase
    ): ViewModel() {
        private var _heroList = MutableLiveData<List<HeroModel>>()
        val heroList: LiveData<List<HeroModel>> get() = _heroList

        private var _errorMsg = MutableLiveData<String?>()
        val errorMsg: LiveData<String?> get() = _errorMsg

        init{
            getData()
        }

        fun getData(filter: Boolean = false, search: String = ""){
            //Scope

            viewModelScope.launch{
                try {
                    val result = withContext(Dispatchers.IO) {
                        getHeroListUseCase.invoke(filter, search)
                    }
                    _heroList.postValue(result)
                    _errorMsg.postValue(null)
                }catch(t: Throwable){
                    _errorMsg.postValue(t.toString())
                    Log.d("LIST_ERROR", t.toString())
                }
            }
        }
    }
