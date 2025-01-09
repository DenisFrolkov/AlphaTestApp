package com.alpha.core.domain.repository

interface NetworkRepository {
    fun checkInternet(): Boolean
}