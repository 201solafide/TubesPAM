package com.example.gameratis.data.remote

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.liveData
import javax.inject.Inject
import javax.inject.Singleton
import androidx.paging.PagingData
import androidx.paging.PagingConfig
import kotlinx.coroutines.flow.Flow

@Singleton
class GameRepository @Inject constructor(private val gameAPI: GameAPI) {
    // fungsi memanggil get now playing game
    // kita mengatur LiveData menjadi Flow
    fun getPosts(): Flow<PagingData<GameRatis>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 200,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {GamePagingSource(gameAPI)}
        ).flow

    }

    // Metode searching
    fun getSearchGames(platform: String?, category: String?, sortBy: String?): Flow<PagingData<GameRatis>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 200,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {GamePagingSource(gameAPI, platform, category, sortBy)}
        ).flow
    }
}