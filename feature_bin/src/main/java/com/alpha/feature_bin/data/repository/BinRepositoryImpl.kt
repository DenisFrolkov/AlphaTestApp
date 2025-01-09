package com.alpha.feature_bin.data.repository

import com.alpha.core.data.model.Bank
import com.alpha.core.data.model.BinInfo
import com.alpha.core.data.model.Country
import com.alpha.core.data.model.Number
import com.alpha.feature_bin.domain.datasource.BinLocalDataSource
import com.alpha.feature_bin.domain.datasource.BinRemoveDataSource
import com.alpha.feature_bin.domain.repository.BinRepository
import javax.inject.Inject

class BinRepositoryImpl @Inject constructor(
    private val binRemoveDataSource: BinRemoveDataSource,
    private val binLocalDataSource: BinLocalDataSource
) : BinRepository {
    override suspend fun getBinInfo(bin: String): BinInfo {
        return binRemoveDataSource.getBinInfo(bin)
    }

    override suspend fun saveBinInfo(
        binInfo: BinInfo,
        number: Number?,
        country: Country?,
        bank: Bank?
    ) {
        binLocalDataSource.saveBinInfo(binInfo, number, country, bank)
    }
}