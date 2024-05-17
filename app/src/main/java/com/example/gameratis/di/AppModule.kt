package com.example.gameratis.di

import com.example.gameratis.data.remote.GameAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@Singleton
object AppModule {

//    kita profit retrofit objek
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(GameAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideGameApi(retrofit: Retrofit): GameAPI =
        retrofit.create(GameAPI::class.java)
}