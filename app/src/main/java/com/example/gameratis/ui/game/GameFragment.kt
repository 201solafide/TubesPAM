package com.example.gameratis.ui.game

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.gameratis.R
import com.example.gameratis.databinding.FragmentGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameFragment : Fragment(R.layout.fragment_game) {
    private val viewModel by viewModels<GameViewModel>()
    private var _binding : FragmentGameBinding? = null

    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentGameBinding.bind(view)

        val adapter = GameAdapter()

        binding.apply {
            rvGame.setHasFixedSize(true)
            rvGame.adapter = adapter.withLoadStateHeaderAndFooter(
                header = GameLoadStateAdapter{adapter.retry()},
                footer = GameLoadStateAdapter{adapter.retry()}
            )
        }

        viewModel.games.observe(viewLifecycleOwner){
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }
}