package com.example.bitirmeprojesi.di.di.domain.repository

import com.example.bitirmeprojesi.model.TravelModel
import retrofit2.Call

interface TravelAppRepository {
    fun getTravelAppDataModel(): Call<TravelModel>
}