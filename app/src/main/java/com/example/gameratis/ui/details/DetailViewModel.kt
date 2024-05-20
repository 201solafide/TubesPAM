package com.example.gameratis.ui.details

import androidx.lifecycle.ViewModel
import com.example.gameratis.data.local.FavoriteGame
import com.example.gameratis.data.local.FavoriteGameRepository
import com.example.gameratis.data.remote.GameRatis
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
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
                    game.release_date,
                    game.freetogame_profile_url
                )
            )
        }
    }

    suspend fun checkGame(id: Int) = repository.checkGame(id)

    fun removeFromFavorite(id: Int){
        CoroutineScope(Dispatchers.IO).launch {
            repository.removeFromFavorite(id)
        }
    }

}