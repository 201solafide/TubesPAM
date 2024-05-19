package com.example.gameratis.ui.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.gameratis.R
import com.example.gameratis.data.local.FavoriteGame
import com.example.gameratis.data.remote.GameRatis
import com.example.gameratis.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
    private val viewModel by viewModels<FavoriteViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoriteBinding.bind(view)

        val adapter = FavoriteAdapter()

        viewModel.game.observe(viewLifecycleOwner){
            adapter.setGameList(it)
            binding.apply {
                rvGame.setHasFixedSize(true)
                rvGame.adapter = adapter
            }
        }

        adapter.setOnItemClickCallback(object : FavoriteAdapter.OnItemClickCallback{
            override fun onItemClick(favoriteGame: FavoriteGame) {
                val games = GameRatis(
                    favoriteGame.id_game,
                    favoriteGame.title,
                    favoriteGame.thumbnail,
                    favoriteGame.short_description,
                    favoriteGame.game_url,
                    favoriteGame.genre,
                    favoriteGame.platform,
                    favoriteGame.publisher,
                    favoriteGame.developer,
                    favoriteGame.release_data,
                    favoriteGame.freetogame_profile_url
                )
                val action = FavoriteFragmentDirections.actionNavFavoriteToNavDetails(games)
                findNavController().navigate(action)
            }
        })
    }
}