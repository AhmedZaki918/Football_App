package com.example.footballapp.ui.online

import android.os.Bundle
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.footballapp.data.model.MatchesResponse
import com.example.footballapp.data.network.Resource
import com.example.footballapp.databinding.ActivityOnlineBinding
import com.example.footballapp.ui.adapter.MainAdapter
import com.example.footballapp.util.Coroutines
import com.example.footballapp.util.handleApiError
import com.example.footballapp.util.hide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class OnlineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnlineBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnlineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.initMatchesList()

        Coroutines.main {
            viewModel.matchesResponse.collectLatest { response ->
                if (response is Resource.Success) {
                    updateUi(response)
                } else if (response is Resource.Failure) {
                    binding.loadingIndicator.hide()
                    handleApiError(response)
                }
            }
        }
    }


    private fun updateUi(response: Resource.Success<MatchesResponse>) {
        val matches = response.value.matches
        binding.apply {
            loadingIndicator.hide()
            recyclerView.visibility = VISIBLE
            ivLogo.load(response.value.competition.emblem)
            recyclerView.adapter = matches?.let { MainAdapter(it) }
        }
        //Save matches for offline version
        if (matches != null) {
            viewModel.saveData(matches)
        }
    }
}