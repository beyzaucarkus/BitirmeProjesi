package com.example.bitirmeprojesi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bitirmeprojesi.model.TravelModel
import com.example.bitirmeprojesi.di.di.domain.usecase.TravelAppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(private val useCase: TravelAppUseCase): ViewModel(){

    private val _popularMovieList = MutableLiveData<TravelModel>()
    val blogData : LiveData<TravelModel> = _popularMovieList

    init{
        getObserverLiveData()
    }

    fun getObserverLiveData() {
        CoroutineScope(Dispatchers.IO).launch {
            useCase.getData().enqueue(object : Callback<TravelModel>{
                override fun onResponse(call: Call<TravelModel>, response: Response<TravelModel>) {
                    _popularMovieList.value = response.body()
                }

                override fun onFailure(call: Call<TravelModel>, t: Throwable) {
                    println("hata var")
                }

            })
        }

    }

}