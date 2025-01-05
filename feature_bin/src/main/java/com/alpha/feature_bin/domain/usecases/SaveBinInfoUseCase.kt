package com.alpha.feature_bin.domain.usecases

import com.alpha.core.models.BankDomain
import com.alpha.core.models.BinInfoDomain
import com.alpha.core.models.CountryDomain
import com.alpha.core.models.NumberDomain
import com.alpha.feature_bin.data.source.BinInfoDataSource

class SaveBinInfoUseCase(private val dataSource: BinInfoDataSource) {
    suspend operator fun invoke(
        binInfoDomain: BinInfoDomain,
        numberDomain: NumberDomain,
        countryDomain: CountryDomain,
        bankDomain: BankDomain
    ): Unit {
        return dataSource.saveBinInfo(binInfoDomain, numberDomain, countryDomain, bankDomain)
    }
}