package com.alpha.feature_history.domain.repository

import com.alpha.core.data.model.BinInfo

interface HistoryBinLocalRepository {
    suspend fun getAllBinInfoWithDetails(): List<BinInfo>
}