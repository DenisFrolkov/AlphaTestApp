package com.alpha.core.repository

import com.alpha.core.data.model.BinInfo

interface BinInfoRepository {
    suspend fun getBinInfo(bin: String): BinInfo
}