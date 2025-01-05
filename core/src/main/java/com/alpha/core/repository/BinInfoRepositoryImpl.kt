package com.alpha.core.repository

import com.alpha.core.data.database.BinDao
import com.alpha.core.data.network.ApiService
import com.alpha.core.models.BankDomain
import com.alpha.core.models.BinInfoDomain
import com.alpha.core.models.CountryDomain
import com.alpha.core.models.NumberDomain
import com.alpha.feature_bin.data.mappers.BankMapper.toEntity
import com.alpha.feature_bin.data.mappers.BinInfoMapper.toDomain
import com.alpha.feature_bin.data.mappers.BinInfoMapper.toEntity
import com.alpha.feature_bin.data.mappers.CountryMapper.toEntity
import com.alpha.feature_bin.data.mappers.NumberMapper.toEntity
import com.alpha.feature_bin.domain.repository.BinInfoRepository
import javax.inject.Inject

class BinInfoRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val binInfoDao: BinDao
) : BinInfoRepository {
    override suspend fun fetchBinInfo(bin: String): BinInfoDomain {
        val response = apiService.getBinInfo(bin)
        return if (response.isSuccessful) {
            response.body()?.toDomain()!!
        } else {
            throw Exception("Error")
        }
    }

    override suspend fun saveBinInfo(
        binInfoDomain: BinInfoDomain,
        numberDomain: NumberDomain,
        countryDomain: CountryDomain,
        bankDomain: BankDomain
    ) {
        binInfoDao.insertFullData(
            binInfoDomain.toEntity(),
            numberDomain.toEntity(),
            countryDomain.toEntity(),
            bankDomain.toEntity()
        )
    }
}