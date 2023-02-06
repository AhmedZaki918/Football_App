package com.example.footballapp.util

import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import javax.inject.Inject

class NetworkConnection @Inject constructor(private var connectivityManager: ConnectivityManager) {


    var isConnected = false

    fun registerNetworkCallback() {
        connectivityManager.registerDefaultNetworkCallback(object :
            ConnectivityManager.NetworkCallback() {

            override fun onAvailable(network: Network) {
                isConnected = true
            }

            override fun onLost(network: Network) {
                isConnected = false
            }
        })
    }


    fun unregisterNetworkCallback() {
        connectivityManager.unregisterNetworkCallback(ConnectivityManager.NetworkCallback())
    }
}