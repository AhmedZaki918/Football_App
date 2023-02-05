package com.example.footballapp.data.network

import com.example.footballapp.data.model.MatchesResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface APIFootball {

    @GET("/v4/competitions/2021/matches")
    suspend fun getMatches(
        @Header("X-Auth-Token") token: String,
        @Query("dateFrom") dateFrom: String,
        @Query("dateTo") dateTo: String
    ): MatchesResponse
}