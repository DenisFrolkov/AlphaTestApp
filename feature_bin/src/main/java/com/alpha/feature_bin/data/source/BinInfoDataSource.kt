package com.alpha.feature_bin.data.source

import com.alpha.core.models.BankDomain
import com.alpha.core.models.BinInfoDomain
import com.alpha.core.models.CountryDomain
import com.alpha.core.models.NumberDomain
import com.alpha.feature_bin.domain.repository.BinInfoRepository
import javax.inject.Inject

class BinInfoDataSource @Inject constructor(
    private val binInfoRepository: BinInfoRepository
) {
    suspend fun getBinInfo(bin: String): BinInfoDomain {
        return binInfoRepository.fetchBinInfo(bin)
    }

    suspend fun saveBinInfo(
        binInfoDomain: BinInfoDomain,
        numberDomain: NumberDomain,
        countryDomain: CountryDomain,
        bankDomain: BankDomain
    ){
        return binInfoRepository.saveBinInfo(binInfoDomain, numberDomain, countryDomain, bankDomain)
    }
}