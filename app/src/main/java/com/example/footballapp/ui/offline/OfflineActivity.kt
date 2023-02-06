package com.example.footballapp.ui.offline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.footballapp.databinding.ActivityOfflineBinding
import com.example.footballapp.ui.adapter.MainAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OfflineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOfflineBinding
    private lateinit var viewModel: OfflineViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOfflineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[OfflineViewModel::class.java]
        // Update ui
        viewModel.displayMatches().observe(this){ matches ->
            binding.apply {
                recyclerViewOffline.adapter = MainAdapter(matches)
            }
        }
    }
}