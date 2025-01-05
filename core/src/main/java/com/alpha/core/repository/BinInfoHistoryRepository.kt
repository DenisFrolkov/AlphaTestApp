package com.alpha.core.repository

import com.alpha.core.data.database.models.BinInfoWithDetails

interface BinInfoHistoryRepository {
    suspend fun getAllBinInfoHistory(): List<BinInfoWithDetails>
}