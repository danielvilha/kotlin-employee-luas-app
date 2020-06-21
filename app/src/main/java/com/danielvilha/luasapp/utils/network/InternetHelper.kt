package com.danielvilha.luasapp.utils.network

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Singleton

/**
 * Created by danielvilha on 21/06/20
 */
@Singleton
class InternetHelper constructor(private val context: Context) {

    fun isInternetAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnected ?: false
    }
}