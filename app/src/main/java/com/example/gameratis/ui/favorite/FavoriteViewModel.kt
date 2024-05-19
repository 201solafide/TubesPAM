package com.example.gameratis.ui.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.gameratis.data.local.FavoriteGameRepository

class FavoriteViewModel @ViewModelInject constructor(
    private val repository: FavoriteGameRepository
): ViewModel() {
    val game = repository.getFavoriteGame()
}