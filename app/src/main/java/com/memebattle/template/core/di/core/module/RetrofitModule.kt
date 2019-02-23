package com.memebattle.template.core.di.core.module

import com.memebattle.template.features.auth.core.data.ApiGame
import com.memebattle.template.features.auth.core.domain.interactor.GameApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule(var url: String) {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    @Provides
    @Singleton
    fun providesGameApiService(retrofit: Retrofit): GameApiService {
        val api = retrofit.create(ApiGame::class.java)
        return GameApiService(api)
    }
}