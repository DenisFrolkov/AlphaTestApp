package com.alpha.feature_history.data.source

import com.alpha.core.data.database.BinDao
import com.alpha.core.data.model.mappers.BinInfoWithDetailsMapper.toDomainList
import com.alpha.core.data.model.BinInfo
import com.alpha.feature_history.domain.datasource.HistoryBinLocalDataSource
import javax.inject.Inject

class HistoryBinLocalDataSourceImpl @Inject constructor(
    private val binDao: BinDao
): HistoryBinLocalDataSource {
    override suspend fun getAllBinInfoWithDetails(): List<BinInfo> {
        return try {
            val response = binDao.getAllBinInfoWithDetails()
            response.toDomainList()
        } catch (e: Exception) {
            throw RuntimeException("$e")
        }
    }
}