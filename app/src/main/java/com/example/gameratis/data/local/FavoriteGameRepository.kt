package com.example.gameratis.data.local

import javax.inject.Inject

class FavoriteGameRepository @Inject constructor(
    private val favoriteGameDao: FavoriteGameDao
) {
    suspend fun addToFavorite(favoriteGame: FavoriteGame) =
        favoriteGameDao.addToFavorite(favoriteGame)


    fun getFavoriteGame() = favoriteGameDao.getFavoriteGame()

    suspend fun checkGame(id: Int) = favoriteGameDao.checkGame(id)
    suspend fun removeFromFavorite(id: Int){
        favoriteGameDao.removeFavorite(id)
    }
}