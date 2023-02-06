package com.example.footballapp.ui.offline

import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.footballapp.R
import com.example.footballapp.data.model.MatchesItem
import com.example.footballapp.databinding.ActivityOfflineBinding
import com.example.footballapp.ui.adapter.MainAdapter
import com.example.footballapp.util.toast
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
        // Conform the user (the data has been loaded in offline mode) via toast message
        toast(getString(R.string.offline), Toast.LENGTH_LONG)

        viewModel.displayMatches().observe(this) { matches ->
            updateUi(matches)
        }
    }

    private fun updateUi(matches: List<MatchesItem>) {
        binding.apply {
            if (matches.isNotEmpty()) {
                ivLogo.load(matches[0].competition.emblem)
                recyclerViewOffline.adapter = MainAdapter(matches)
            } else {
                recyclerViewOffline.visibility = INVISIBLE
                tvNoData.visibility = VISIBLE
            }
        }
    }
}