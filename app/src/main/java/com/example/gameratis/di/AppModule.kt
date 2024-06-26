package com.example.gameratis.di

import android.content.Context
import androidx.room.Room
import com.example.gameratis.data.local.FavoriteGameDatabase
import com.example.gameratis.data.remote.GameAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Provide Retrofit instance
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(GameAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    // Provide GameAPI instance
    @Provides
    @Singleton
    fun provideGameApi(retrofit: Retrofit): GameAPI =
        retrofit.create(GameAPI::class.java)

    // Provide FavoriteGameDatabase instance
    @Provides
    @Singleton
    fun provideFavGameDatabase(
        @ApplicationContext app: Context
    ): FavoriteGameDatabase = Room.databaseBuilder(
        app,
        FavoriteGameDatabase::class.java,
        "Free_Game"
    )
        .fallbackToDestructiveMigration()
        .build()

    // Provide DAO instance
    @Provides
    @Singleton
    fun provideFavGameDao(db: FavoriteGameDatabase) = db.getFavoriteGameDao()


}
