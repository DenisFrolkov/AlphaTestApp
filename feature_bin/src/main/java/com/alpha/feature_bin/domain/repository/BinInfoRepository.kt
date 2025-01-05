package com.alpha.feature_bin.domain.repository

import com.alpha.core.models.BankDomain
import com.alpha.core.models.BinInfoDomain
import com.alpha.core.models.CountryDomain
import com.alpha.core.models.NumberDomain

interface BinInfoRepository {
    suspend fun fetchBinInfo(bin: String): BinInfoDomain
    suspend fun saveBinInfo(
        binInfoDomain: BinInfoDomain,
        numberDomain: NumberDomain,
        countryDomain: CountryDomain,
        bankDomain: BankDomain
    )
}