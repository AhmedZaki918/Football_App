package com.example.footballapp.data.model

data class MatchesResponse(
    val competition: Competition,
    val filters: Filters,
    val matches: List<MatchesItem>?
)