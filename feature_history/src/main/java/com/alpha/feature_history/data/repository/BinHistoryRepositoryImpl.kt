package com.alpha.feature_history.data.repository

import com.alpha.core.data.model.BinInfo
import com.alpha.core.domain.source.LocalDataSource
import com.alpha.core.domain.repository.BinHistoryRepository
import javax.inject.Inject

class BinHistoryRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : BinHistoryRepository {

    override suspend fun getAllBinInfoWithDetails(): List<BinInfo> {
        return localDataSource.getAllBinInfoWithDetails()
    }

}