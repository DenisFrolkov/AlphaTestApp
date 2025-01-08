package com.alpha.feature_bin.domain.repository

import com.alpha.core.data.model.Bank
import com.alpha.core.data.model.BinInfo
import com.alpha.core.data.model.Country
import com.alpha.core.data.model.Number

interface BinRepository {
    suspend fun getBinInfo(bin: String): BinInfo
    suspend fun saveBinInfo(
        binInfo: BinInfo,
        number: Number?,
        country: Country?,
        bank: Bank?
    )
}