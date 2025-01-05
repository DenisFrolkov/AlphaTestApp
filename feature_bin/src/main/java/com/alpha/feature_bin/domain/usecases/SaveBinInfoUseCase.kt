package com.alpha.feature_bin.domain.usecases

import com.alpha.core.data.model.Bank
import com.alpha.core.data.model.BinInfo
import com.alpha.core.data.model.Country
import com.alpha.core.data.model.Number
import com.alpha.core.repository.BinInfoHistoryRepository

class SaveBinInfoUseCase(private val binInfoHistoryRepository: BinInfoHistoryRepository) {
    suspend operator fun invoke(
        binInfo: BinInfo,
        number: Number,
        country: Country,
        bank: Bank
    ) {
        binInfoHistoryRepository.saveBinInfo(binInfo, number, country, bank)
    }
}