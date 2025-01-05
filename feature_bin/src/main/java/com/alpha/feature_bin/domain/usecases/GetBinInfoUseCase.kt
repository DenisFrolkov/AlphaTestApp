package com.alpha.feature_bin.domain.usecases

import com.alpha.core.models.BinInfoDomain
import com.alpha.feature_bin.data.source.BinInfoDataSource

class GetBinInfoUseCase(private val dataSource: BinInfoDataSource) {
    suspend operator fun invoke(bin: String): BinInfoDomain {
        return dataSource.getBinInfo(bin)
    }
}