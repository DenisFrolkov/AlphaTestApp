package com.alpha.core.repository

import com.alpha.core.data.model.Bank
import com.alpha.core.data.model.BinInfo
import com.alpha.core.data.model.Country
import com.alpha.core.data.model.Number

interface BinInfoHistoryRepository {
    suspend fun saveBinInfo(
        binInfo: BinInfo,
        number: Number?,
        country: Country?,
        bank: Bank?
    )
    suspend fun getAllBinInfoWithDetails(): List<BinInfo>
}