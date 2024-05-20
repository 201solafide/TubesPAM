package com.example.gameratis.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameRatis(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String,
    val game_url: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val developer: String,
    val release_date: String,
    val freetogame_profile_url: String
) : Parcelable
    , List<Any> {
    val BASE_URL get() = "https://www.freetogame.com/api/"
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun get(index: Int): Any {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<Any> {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<Any> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<Any> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<Any> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: Any): Int {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: Any): Int {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<Any>): Boolean {
        TODO("Not yet implemented")
    }

    override fun contains(element: Any): Boolean {
        TODO("Not yet implemented")
    }
}

