package com.example.bitirmeprojesi.data.remote.repository
import com.example.bitirmeprojesi.di.di.retrofit.RetrofitServiceInstance
import com.example.bitirmeprojesi.model.TravelModel
import com.example.bitirmeprojesi.di.di.domain.repository.TravelAppRepository
import retrofit2.Call

class TravelAppRepositoryImp(private val api: RetrofitServiceInstance): TravelAppRepository {
    override fun getTravelAppDataModel(): Call<TravelModel> {
        return api.getTravelApp()
    }

}