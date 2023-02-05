package com.example.footballapp.data.model

data class MatchesItem(
    val matchday: Int? = 0,
    val awayTeam: AwayTeam,
    val competition: Competition,
    val utcDate: String? = "",
    val score: Score,
    val homeTeam: HomeTeam,
    val id: Int? = 0,
    val status: String? = ""
)