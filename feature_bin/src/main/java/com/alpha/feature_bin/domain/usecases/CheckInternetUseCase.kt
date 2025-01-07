package com.alpha.feature_bin.domain.usecases

import com.alpha.core.domain.repository.NetworkRepository

class CheckInternetUseCase(private val networkManager: NetworkRepository) {
    operator fun invoke(): Boolean {
        return networkManager.checkInternet()
    }
}