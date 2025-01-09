package com.alpha.feature_bin.domain.datasource

import com.alpha.core.data.model.BinInfo

interface BinRemoveDataSource {
    suspend fun getBinInfo(bin: String): BinInfo
}