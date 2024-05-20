package com.example.gameratis.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteGameDao {
    @Insert
    suspend fun addToFavorite(favoriteGame: FavoriteGame)

    @Query("SELECT * FROM favorite_game")
    fun getFavoriteGame(): LiveData<List<FavoriteGame>>

    @Query("SELECT count(*) FROM favorite_game WHERE favorite_game.id_game = :id")
    suspend fun checkGame(id: kotlin.Int):  Int

    @Query("DELETE FROM favorite_game WHERE favorite_game.id_game = :id")
    suspend fun removeFavorite(id: kotlin.Int): Int
}