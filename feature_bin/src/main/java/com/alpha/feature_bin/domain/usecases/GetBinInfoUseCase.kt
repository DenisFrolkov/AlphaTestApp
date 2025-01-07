package com.alpha.feature_bin.domain.usecases

import com.alpha.core.data.model.BinInfo
import com.alpha.core.domain.repository.BinRepository
import javax.inject.Inject

class GetBinInfoUseCase @Inject constructor(private val binRepository: BinRepository) {
    suspend operator fun invoke(bin: String): BinInfo {
        return binRepository.getBinInfo(bin)
    }
}