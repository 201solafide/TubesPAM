package com.example.gameratis.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.gameratis.R
import com.example.gameratis.data.local.FavoriteGame
import com.example.gameratis.databinding.ItemGameBinding

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private lateinit var list : List<FavoriteGame>

    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    // set onclick adapter
    fun setGameList(list: List<FavoriteGame>){
        this.list = list
        notifyDataSetChanged()
    }


    inner class FavoriteViewHolder(private val binding: ItemGameBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(favoriteGame: FavoriteGame){
            with(binding){
                Glide.with(itemView)
                    .load(favoriteGame.thumbnail)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(ivGamePoster)

                tvGameTitle.text = favoriteGame.title
                binding.root.setOnClickListener {
                    onItemClickCallback?.onItemClick(favoriteGame)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    interface  OnItemClickCallback{
        fun onItemClick(favoriteGame: FavoriteGame)
    }
}