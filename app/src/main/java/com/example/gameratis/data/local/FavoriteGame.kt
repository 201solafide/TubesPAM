package com.example.gameratis.data.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity(tableName = "favorite_game")
@Parcelize
data class FavoriteGame(
    val id_game: String,
    val title: String,
    val thumbnail: String,
    val short_description: String,
    val game_url: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val developer: String,
    val release_data: String,
    val freetogame_profile_url: String
): Serializable, Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
    val BASE_URL get() = "https://www.freetogame.com/api/"
}
