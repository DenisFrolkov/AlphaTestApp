package com.alpha.core.source

import com.alpha.core.data.model.BinInfo

interface RemoveDataSource {
    suspend fun getBinInfo(bin: String): BinInfo
}