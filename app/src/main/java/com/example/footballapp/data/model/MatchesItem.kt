package com.example.footballapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.footballapp.data.local.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class MatchesItem(
    @PrimaryKey
    val id: Int? = 0,
    val matchday: Int? = 0,
    val awayTeam: AwayTeam,
    val competition: Competition,
    val utcDate: String? = "",
    val score: Score,
    val homeTeam: HomeTeam,
    val status: String? = ""
)