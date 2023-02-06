package com.example.footballapp.data.repository

import com.example.footballapp.data.local.Constants.API_KEY
import com.example.footballapp.data.local.MatchDao
import com.example.footballapp.data.model.MatchesItem
import com.example.footballapp.data.network.APIFootball
import com.example.footballapp.data.network.SafeApiCall
import javax.inject.Inject

class MainRepo @Inject constructor(
    private val api: APIFootball,
    private val dao: MatchDao
) : SafeApiCall {

    suspend fun getMatchesList() = safeApiCall {
        api.getMatches(API_KEY, "2023-02-05", "2023-02-12")
    }

    // Save all matches list to show it (in failure connection from server)
    suspend fun saveMatchesList(matches: List<MatchesItem>){
        for (match in matches){
            dao.addMatch(match)
        }
    }
}