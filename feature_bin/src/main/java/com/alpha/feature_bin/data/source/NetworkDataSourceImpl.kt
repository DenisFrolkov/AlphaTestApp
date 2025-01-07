package com.alpha.feature_bin.data.source

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.alpha.core.domain.source.NetworkDataSource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : NetworkDataSource {
    override fun isInternetAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        return capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }
}