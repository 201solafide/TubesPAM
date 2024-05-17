package com.example.gameratis.ui.game

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.gameratis.R
import com.example.gameratis.data.remote.GameRatis
import com.example.gameratis.databinding.ItemGameBinding

class GameAdapter : PagingDataAdapter<GameRatis, GameAdapter.GameViewHolder>(COMPARATOR) {
    inner class GameViewHolder(private val binding: ItemGameBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun bind(gameRatis: GameRatis){
                with(binding){
                    Glide.with(itemView)
                        .load("${gameRatis.BASE_URL}.${gameRatis.platform}")
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.ic_error)
                        .into(ivGamePoster)

                    tvGameTitle.text = gameRatis.title
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val currtentItem = getItem(position)
        if (currtentItem != null){
            holder.bind(currtentItem)
        }
    }

    companion object{
        private val COMPARATOR = object  : DiffUtil.ItemCallback<GameRatis>(){
            override fun areItemsTheSame(oldItem: GameRatis, newItem: GameRatis): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: GameRatis, newItem: GameRatis): Boolean =
                oldItem == newItem

        }
    }

}