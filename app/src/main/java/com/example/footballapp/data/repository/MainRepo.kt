package com.example.footballapp.data.repository

import com.example.footballapp.data.local.Constants
import com.example.footballapp.data.local.Constants.API_KEY
import com.example.footballapp.data.network.APIFootball
import com.example.footballapp.data.network.SafeApiCall
import javax.inject.Inject

class MainRepo @Inject constructor(
    private val api: APIFootball
) : SafeApiCall {

    suspend fun getMatchesList() = safeApiCall {
        api.getMatches(API_KEY, "2023-02-05", "2023-02-11")
    }
}