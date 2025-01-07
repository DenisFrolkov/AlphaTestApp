package com.alpha.feature_history.domain.usecase

import com.alpha.core.data.model.BinInfo
import com.alpha.core.domain.repository.BinHistoryRepository
import javax.inject.Inject

class GetAllBinInfoUseCase @Inject constructor(private val binHistoryRepository: BinHistoryRepository) {
    suspend operator fun invoke(): List<BinInfo> {
        return binHistoryRepository.getAllBinInfoWithDetails()
    }
}