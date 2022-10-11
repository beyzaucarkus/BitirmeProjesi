package com.example.bitirmeprojesi.di.di.modele

import com.example.bitirmeprojesi.data.remote.repository.TravelAppRepositoryImp
import com.example.bitirmeprojesi.di.di.retrofit.RetrofitServiceInstance
import com.example.bitirmeprojesi.di.di.domain.repository.TravelAppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    var baseURL = "https://633800d85327df4c43db5614.mockapi.io/"


    @Provides
    @Singleton
    fun getRetrofitServicesInsance(retrofit: Retrofit): RetrofitServiceInstance {
        return retrofit.create(RetrofitServiceInstance::class.java)
    }

    @Provides
    @Singleton
    fun getRetroInstanca(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesBlogDataRepository(retrofitServiceInstance: RetrofitServiceInstance) : TravelAppRepository {
        return TravelAppRepositoryImp(retrofitServiceInstance)
    }


}

