package com.example.gameratis.ui.game

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.example.gameratis.R
import com.example.gameratis.data.remote.GameRatis
import com.example.gameratis.databinding.FragmentGameBinding
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class GameFragment : Fragment(R.layout.fragment_game), GameAdapter.OnItemClickListener {
    private val viewModel by viewModels<GameViewModel>()
    private var _binding : FragmentGameBinding? = null

    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentGameBinding.bind(view)

        val adapter = GameAdapter(this)

        binding.apply {
            rvGame.setHasFixedSize(true)
            rvGame.adapter = adapter.withLoadStateHeaderAndFooter(
                header = GameLoadStateAdapter{adapter.retry()},
                footer = GameLoadStateAdapter{adapter.retry()}
            )

            btnTryAgain.setOnClickListener {
                adapter.retry()
            }
        }

        adapter.addLoadStateListener { loadState ->
            binding.apply {
                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                rvGame.isVisible = loadState.source.refresh is LoadState.NotLoading
                btnTryAgain.isVisible = loadState.source.refresh is LoadState.Error //btn ketika error
                tvFailed.isVisible = loadState.source.refresh is LoadState.Error

                // btn ketika tidak ditemukan
                if (loadState.source.refresh is LoadState.NotLoading && loadState.append.endOfPaginationReached && adapter.itemCount < 1) {
                    rvGame.isVisible = false
                        tvNotFound.isVisible = true
                } else {
                    tvNotFound.isVisible = false
                }
            }
        }

        viewModel.games.observe(viewLifecycleOwner){
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null){
                    val parameters = query.split(" ").map {
                        val param = it.split(":")
                        param[0] to param.getOrElse(1) { "" }
                    }.toMap()

                    val platform = parameters["platform"] ?: ""
                    val category = parameters["category"] ?: ""
                    val sortBy = parameters["sortBy"] ?: ""

                    binding.rvGame.scrollToPosition(0)
                    viewModel.searchGames(platform, category, sortBy)
                    searchView.clearFocus()

//                    binding.rvGame.scrollToPosition(0)
//                    viewModel.searchGames(platfrom = "", category = "", sortBy = "")
//                    searchView.clearFocus()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }

    override fun onItemClick(gameRatis: GameRatis) {
//        val action = GameFragmentDirections.actionNavGameRatisToNavDetails(gameRatis)
        val action = GameFragmentDirections.actionNavGameToNavDetails(gameRatis)
        findNavController().navigate(action)
    }

}
