package com.example.footballapp.data.repository

import androidx.lifecycle.LiveData
import com.example.footballapp.data.local.MatchDao
import com.example.footballapp.data.model.MatchesItem
import javax.inject.Inject

class OfflineRepo @Inject constructor(
    private val dao: MatchDao
) {

    fun getMatchesList(): LiveData<List<MatchesItem>> {
        return dao.getAllMatches()
    }
}