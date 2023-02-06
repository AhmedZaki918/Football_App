package com.example.footballapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.footballapp.data.model.MatchesItem

@Database(
    entities = [MatchesItem::class],
    version = 1, exportSchema = false
)
@TypeConverters(Converter::class)
abstract class MatchDatabase: RoomDatabase() {
    abstract fun getMatchDao(): MatchDao
}