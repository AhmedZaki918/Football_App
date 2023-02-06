package com.example.footballapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballapp.data.local.Constants.TABLE_NAME
import com.example.footballapp.data.model.MatchesItem

@Dao
interface MatchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMatch(match: MatchesItem)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllMatches(): LiveData<List<MatchesItem>>
}