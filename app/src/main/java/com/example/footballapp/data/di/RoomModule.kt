package com.example.footballapp.data.di

import android.app.Application
import androidx.room.Room
import com.example.footballapp.data.local.MatchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) =
        Room.databaseBuilder(app, MatchDatabase::class.java, "match_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideDao(db: MatchDatabase) = db.getMatchDao()
}