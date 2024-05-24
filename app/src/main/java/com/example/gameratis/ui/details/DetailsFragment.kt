package com.example.gameratis.ui.details

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.gameratis.R
import com.example.gameratis.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {
    private val args by navArgs<DetailsFragmentArgs>()
    private val viewModel by viewModels<DetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailsBinding.bind(view)

        binding.apply {
            val gameRatis = args.gameRatis
            Glide.with(this@DetailsFragment).load(gameRatis.thumbnail).error(R.drawable.ic_error)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.isVisible = false
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable,
                        model: Any,
                        target: Target<Drawable>?,
                        dataSource: DataSource,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.isVisible = false
                        tvDescription.isVisible = true
                        tvGameTitle.isVisible = true
                        tvGenre.isVisible = true
                        tvGenre1.isVisible = true
                        tvPlatform.isVisible = true
                        tvPlatform1.isVisible = true
                        tvDeveloper.isVisible = true
                        tvDeveloper1.isVisible = true
                        tvPublisher.isVisible = true
                        tvPublisher1.isVisible = true
                        tvReleaseDate.isVisible = true
                        tvReleaseDate1.isVisible = true

                        return false
                    }

                }).into(ivGamePoster)

            // variabel mengatur toggle
            var isChecked = false
            CoroutineScope(Dispatchers.IO).launch {
                val count = viewModel.checkGame(gameRatis.id)
                withContext(Dispatchers.Main) {
                    if (count > 0) {
                        toggleFavorite.isChecked = false
                        isChecked = true
                    } else {
                        toggleFavorite.isChecked = true
                        isChecked = false
                    }
                }
            }

            tvDescription.text = gameRatis.short_description
            tvGameTitle.text = gameRatis.title
            tvGenre.text = gameRatis.genre
            tvPlatform.text = gameRatis.platform
            tvDeveloper.text = "Developer"
            tvDeveloper1.text = gameRatis.developer
            tvPublisher.text = "Publisher"
            tvPublisher1.text = gameRatis.publisher
            tvReleaseDate.text = "Release Date"
            tvReleaseDate1.text = gameRatis.release_date

            toggleFavorite.setOnClickListener {
                isChecked = !isChecked
                if (isChecked) {
                    viewModel.addToFavorite(gameRatis)
                } else {
                    viewModel.removeFromFavorite(gameRatis.id)
                }
                toggleFavorite.isChecked = isChecked
            }

            // Event Tombol Play
            binding.btPlay.setOnClickListener {
                openUrl(gameRatis.game_url)
            }
        }
    }

    private fun openUrl(url: String) {
        val uri = Uri.parse(url)
        val i = Intent(Intent.ACTION_VIEW, uri)

        startActivity(i)
    }
}