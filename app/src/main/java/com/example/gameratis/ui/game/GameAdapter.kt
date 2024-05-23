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

class GameAdapter(private val listener : OnItemClickListener) : PagingDataAdapter<GameRatis, GameAdapter.GameViewHolder>(COMPARATOR) {
    inner class GameViewHolder(private val binding: ItemGameBinding)
        : RecyclerView.ViewHolder(binding.root){
            init {
                binding.root.setOnClickListener {
                    val position = bindingAdapterPosition
                    if (position != RecyclerView.NO_POSITION){
                        val item = getItem(position)
                        if (item != null){
                            listener.onItemClick(item)
                        }
                    }
                }
            }
            fun bind(gameRatis: GameRatis){
                with(binding){
                    Glide.with(itemView)
                        .load(gameRatis.thumbnail)
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
        val currentItem = getItem(position)
        if (currentItem != null){
            holder.bind(currentItem)
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

    // membangun interface untuk dekripsi
    interface OnItemClickListener{
        fun onItemClick(gameRatis: GameRatis)
    }

}