package com.example.gameratis.data.remote

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepository @Inject constructor() {

    private val gameAPI = RetrofitInstance.api

    fun getPosts(): LiveData<PagingData<GameRatis>> =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 200,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { GamePagingSource(gameAPI, null, null, null) }
        ).liveData

    fun getSearchGames(platform: String, category: String, sortBy: String): LiveData<PagingData<GameRatis>> =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 200,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { GamePagingSource(gameAPI, platform, category, sortBy) }
        ).liveData
}
