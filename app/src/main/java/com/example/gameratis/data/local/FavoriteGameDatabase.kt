package com.example.gameratis.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FavoriteGame::class],
    exportSchema = false,
    version = 1
)

abstract class FavoriteGameDatabase : RoomDatabase(){
    abstract fun getFavoriteGameDao(): FavoriteGameDao
}