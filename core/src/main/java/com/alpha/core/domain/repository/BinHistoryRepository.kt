package com.alpha.core.domain.repository

import com.alpha.core.data.model.BinInfo

interface BinHistoryRepository {
    suspend fun getAllBinInfoWithDetails(): List<BinInfo>
}