package com.alpha.core.repository

interface NetworkRepository {
    fun checkInternet(): Boolean
}