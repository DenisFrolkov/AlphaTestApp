package com.alpha.core.repository

import com.alpha.core.data.database.models.BinInfoWithDetails
import com.alpha.core.models.BinInfoResponse

interface BinInfoRepository {
    suspend fun fetchBinInfo(bin: String): Result<BinInfoResponse>
    suspend fun saveBinInfo(response: BinInfoResponse): Result<Unit>
    suspend fun getAllBinInfoHistory(): List<BinInfoWithDetails>
}