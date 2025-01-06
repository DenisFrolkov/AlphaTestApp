package com.alpha.feature_bin.domain.usecases

import com.alpha.core.repository.NetworkRepository

class CheckInternetUseCase(private val networkManager: NetworkRepository) {
    operator fun invoke(): Boolean {
        return networkManager.checkInternet()
    }
}