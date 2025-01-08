package com.alpha.core.data.network

import com.alpha.core.data.network.models.BinInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{bin}")
    suspend fun getBinInfo(@Path("bin") bin: String): BinInfoResponse
}