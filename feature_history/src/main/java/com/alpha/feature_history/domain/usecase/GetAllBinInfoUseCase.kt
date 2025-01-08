package com.alpha.feature_history.domain.usecase

import com.alpha.core.data.model.BinInfo
import com.alpha.feature_history.domain.repository.HistoryBinLocalRepository
import javax.inject.Inject

class GetAllBinInfoUseCase @Inject constructor(private val historyBinLocalRepository: HistoryBinLocalRepository) {
    suspend operator fun invoke(): List<BinInfo> {
        return historyBinLocalRepository.getAllBinInfoWithDetails()
    }
}