package com.alpha.feature_bin.data.repository

import com.alpha.core.data.model.BinInfo
import com.alpha.core.source.RemoveDataSource
import com.alpha.core.repository.BinInfoRepository
import javax.inject.Inject

class BinInfoRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoveDataSource
) : BinInfoRepository {
    override suspend fun getBinInfo(bin: String): BinInfo {
        return remoteDataSource.getBinInfo(bin)
    }
}