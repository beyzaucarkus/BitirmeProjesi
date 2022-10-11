package com.example.bitirmeprojesi.di.di.retrofit

import com.example.bitirmeprojesi.model.TravelModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceInstance {

    @GET("AllTravelList")
    fun getTravelApp() : Call<TravelModel>


}