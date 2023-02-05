package com.example.footballapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.footballapp.data.network.Resource
import com.example.footballapp.databinding.ActivityMainBinding
import com.example.footballapp.ui.adapter.MainAdapter
import com.example.footballapp.util.Coroutines
import com.example.footballapp.util.handleApiError
import com.example.footballapp.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.initMatchesList()


        Coroutines.main {
            viewModel.matchesResponse.collectLatest { response ->
                   if (response is Resource.Success) {
                       val mainAdapter = response.value.matches?.let { MainAdapter(it) }
                       binding.recyclerView.adapter = mainAdapter
                    } else if (response is Resource.Failure) {
                        handleApiError(response)
                }
            }
        }
    }
}