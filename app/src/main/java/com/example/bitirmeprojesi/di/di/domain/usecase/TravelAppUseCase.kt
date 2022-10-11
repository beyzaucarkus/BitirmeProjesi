package com.example.bitirmeprojesi.di.di.domain.usecase

import com.example.bitirmeprojesi.model.TravelModel
import com.example.bitirmeprojesi.di.di.domain.repository.TravelAppRepository
import retrofit2.Call
import javax.inject.Inject

class TravelAppUseCase @Inject constructor(private val repository: TravelAppRepository) {
    fun getData(): Call<TravelModel> {
        return repository.getTravelAppDataModel()
    }
}