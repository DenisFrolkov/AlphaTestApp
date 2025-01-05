package com.alpha.feature_bin.domain.usecases

import com.alpha.core.data.model.BinInfo
import com.alpha.core.repository.BinInfoRepository
import javax.inject.Inject

class GetBinInfoUseCase @Inject constructor(private val binInfoRepository: BinInfoRepository) {
    suspend operator fun invoke(bin: String): BinInfo {
        return binInfoRepository.getBinInfo(bin)
    }
}