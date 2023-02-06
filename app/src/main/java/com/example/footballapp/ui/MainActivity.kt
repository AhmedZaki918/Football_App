package com.example.footballapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.footballapp.databinding.ActivityMainBinding
import com.example.footballapp.ui.offline.OfflineActivity
import com.example.footballapp.ui.online.OnlineActivity
import com.example.footballapp.util.Coroutines
import com.example.footballapp.util.NetworkConnection
import com.example.footballapp.util.startActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var networkConnection: NetworkConnection
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // If there's a network available
        networkConnection.registerNetworkCallback()
        Coroutines.background {
            if (networkConnection.isConnected) {
                // Display online content
                startActivity(OnlineActivity::class.java)
                finish()
            } else {
                // Display offline content
                startActivity(OfflineActivity::class.java)
                finish()
            }
        }
    }
}