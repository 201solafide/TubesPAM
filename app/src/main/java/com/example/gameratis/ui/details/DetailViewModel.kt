package com.example.gameratis.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.gameratis.data.local.FavoriteGame
import com.example.gameratis.data.local.FavoriteGameRepository
import com.example.gameratis.data.remote.GameRatis
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel @ViewModelInject constructor(
    private val repository: FavoriteGameRepository
): ViewModel(){
    fun addToFavorite(game:GameRatis){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addToFavorite(
                FavoriteGame(
                    game.id,
                    game.title,
                    game.thumbnail,
                    game.short_description,
                    game.game_url,
                    game.genre,
                    game.platform,
                    game.publisher,
                    game.developer,
                    game.release_data,
                    game.freetogame_profile_url
                )
            )
        }
    }

    suspend fun checkGame(id: String) = repository.checkGame(id)

    fun removeFromFavorite(id: String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.removeFromFavorite(id)
        }
    }

}