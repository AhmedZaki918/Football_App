package com.example.footballapp.data.model

data class Score(
    val duration: String? = "",
    val winner: String? = "",
    val halfTime: HalfTime,
    val fullTime: FullTime
)