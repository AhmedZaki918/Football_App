package com.example.footballapp.ui.online

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.model.MatchesItem
import com.example.footballapp.data.model.MatchesResponse
import com.example.footballapp.data.network.Resource
import com.example.footballapp.data.repository.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: MainRepo
) : ViewModel() {

    private val _matchesResponse = MutableStateFlow<Resource<MatchesResponse>>(Resource.Idle)
    val matchesResponse: StateFlow<Resource<MatchesResponse>> = _matchesResponse

    fun initMatchesList(){
        viewModelScope.launch {
            _matchesResponse.value = repo.getMatchesList()
        }
    }

    fun saveData(matches: List<MatchesItem>){
        viewModelScope.launch {
            repo.saveMatchesList(matches)
        }
    }
}