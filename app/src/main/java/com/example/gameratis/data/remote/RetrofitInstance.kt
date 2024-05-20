package com.example.gameratis.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: GameAPI by lazy {
        Retrofit.Builder()
            .baseUrl(GameAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameAPI::class.java)
    }
}
