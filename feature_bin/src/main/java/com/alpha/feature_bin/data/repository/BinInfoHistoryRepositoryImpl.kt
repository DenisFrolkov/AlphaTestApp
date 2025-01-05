package com.alpha.feature_bin.data.repository

import com.alpha.core.data.model.Bank
import com.alpha.core.data.model.BinInfo
import com.alpha.core.data.model.Country
import com.alpha.core.data.model.Number
import com.alpha.core.source.LocalDataSource
import com.alpha.core.repository.BinInfoHistoryRepository
import javax.inject.Inject

class BinInfoHistoryRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : BinInfoHistoryRepository {
    override suspend fun saveBinInfo(
        binInfo: BinInfo,
        number: Number,
        country: Country,
        bank: Bank
    ) {
        localDataSource.saveBinInfo(binInfo, number, country, bank)
    }

    override suspend fun getAllBinInfoWithDetails(): List<BinInfo> {
        return localDataSource.getAllBinInfoWithDetails()
    }

}