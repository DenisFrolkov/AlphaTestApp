package com.alpha.feature_bin.data.repository

import com.alpha.core.data.model.Bank
import com.alpha.core.data.model.BinInfo
import com.alpha.core.data.model.Country
import com.alpha.core.data.model.Number
import com.alpha.core.domain.source.RemoveDataSource
import com.alpha.core.domain.repository.BinRepository
import com.alpha.core.domain.source.LocalDataSource
import javax.inject.Inject

class BinRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoveDataSource,
    private val localDataSource: LocalDataSource
) : BinRepository {
    override suspend fun getBinInfo(bin: String): BinInfo {
        return remoteDataSource.getBinInfo(bin)
    }

    override suspend fun saveBinInfo(
        binInfo: BinInfo,
        number: Number?,
        country: Country?,
        bank: Bank?
    ) {
        localDataSource.saveBinInfo(binInfo, number, country, bank)
    }
}