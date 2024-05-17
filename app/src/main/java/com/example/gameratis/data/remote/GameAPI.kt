package com.example.gameratis.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface GameAPI {
    companion object{
        const val BASE_URL = "https://www.freetogame.com/api/"
    }
    @GET("games")
    suspend fun getPosts(
        @Query("page") page: Int
    ): GameResponse
//    suspend fun getPosts(position: Int): Call<ArrayList<GameResponse>>

    @GET("games?platform")
    suspend fun getSearchGame(
        @Query("platform") platform: String? = null,
        @Query("category") category: String? = null,
        @Query("sort-by") sortBy: String? = null,
        position: Int
    ): GameResponse
}