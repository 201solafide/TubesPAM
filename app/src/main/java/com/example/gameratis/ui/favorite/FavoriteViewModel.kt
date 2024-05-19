package com.example.gameratis.ui.favorite


import androidx.lifecycle.ViewModel
import com.example.gameratis.data.local.FavoriteGameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: FavoriteGameRepository
): ViewModel() {
    val game = repository.getFavoriteGame()
}