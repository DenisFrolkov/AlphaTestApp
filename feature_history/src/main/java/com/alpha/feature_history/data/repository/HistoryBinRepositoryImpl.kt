package com.alpha.feature_history.data.repository

import com.alpha.core.data.model.BinInfo
import com.alpha.feature_history.domain.datasource.HistoryBinLocalDataSource
import com.alpha.feature_history.domain.repository.HistoryBinLocalRepository
import javax.inject.Inject

class HistoryBinRepositoryImpl @Inject constructor(
    private val historyBinLocalDataSource: HistoryBinLocalDataSource
) : HistoryBinLocalRepository {

    override suspend fun getAllBinInfoWithDetails(): List<BinInfo> {
        return historyBinLocalDataSource.getAllBinInfoWithDetails()
    }

}