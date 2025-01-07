package com.alpha.feature_bin.data.repository

import com.alpha.core.domain.repository.NetworkRepository
import com.alpha.core.domain.source.NetworkDataSource
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource
) : NetworkRepository {
    override fun checkInternet(): Boolean {
        return networkDataSource.isInternetAvailable()
    }
}

class NoInternetException(message: String) : Exception(message)