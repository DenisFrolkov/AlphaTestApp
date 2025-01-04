package com.alpha.core.data.network

import com.alpha.core.models.BinInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{bin}")
    suspend fun getBinInfo(@Path("bin") bin: String): BinInfoResponse
}