package com.example.gameratis.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface GameAPI {
    companion object {
        const val BASE_URL = "https://www.freetogame.com/api/"
    }

    @GET("games")
    suspend fun getPosts(
        @Query("page") position: Int
    ): List<GameRatis>

    @GET("games")
    suspend fun getSearch(
        @Query("platform") platform: String,
        @Query("category") category: String,
        @Query("sort-by") sortBy: String
    ): List<GameRatis>

    // @GET("game")
    //suspend fun getGameDetailById(
    //    @Query("id") gameId: Int
    //): GameDetailDto
}
