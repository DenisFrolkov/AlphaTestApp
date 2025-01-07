package com.alpha.core.domain.source

interface NetworkDataSource {
    fun isInternetAvailable(): Boolean
}