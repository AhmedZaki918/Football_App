package com.example.footballapp.ui.offline

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.model.MatchesItem
import com.example.footballapp.data.repository.OfflineRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfflineViewModel @Inject constructor(
    private val repo: OfflineRepo
    ) : ViewModel() {

    fun displayMatches() = repo.getMatchesList()
}