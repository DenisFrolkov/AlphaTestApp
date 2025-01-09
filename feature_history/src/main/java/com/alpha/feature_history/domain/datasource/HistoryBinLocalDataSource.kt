package com.alpha.feature_history.domain.datasource

import com.alpha.core.data.model.BinInfo

interface HistoryBinLocalDataSource {
    suspend fun getAllBinInfoWithDetails(): List<BinInfo>
}