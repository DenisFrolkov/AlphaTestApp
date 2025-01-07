package com.alpha.feature_history.data.source

import android.util.Log
import com.alpha.core.data.database.BinDao
import com.alpha.core.data.model.mappers.BinInfoWithDetailsMapper.toDomainList
import com.alpha.core.data.model.Bank
import com.alpha.core.data.model.BinInfo
import com.alpha.core.data.model.Country
import com.alpha.core.data.model.Number
import com.alpha.core.data.model.mappers.BankMapper.toEntity
import com.alpha.core.data.model.mappers.BinInfoMapper.toEntity
import com.alpha.core.data.model.mappers.CountryMapper.toEntity
import com.alpha.core.data.model.mappers.NumberMapper.toEntity
import com.alpha.core.domain.source.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val binDao: BinDao
): LocalDataSource {
    override suspend fun saveBinInfo(
        binInfo: BinInfo,
        number: Number?,
        country: Country?,
        bank: Bank?
    ) {
        binDao.insertFullData(binInfo.toEntity(), number?.toEntity(), country?.toEntity(), bank?.toEntity())
    }

    override suspend fun getAllBinInfoWithDetails(): List<BinInfo> {
//        Log.d("LocalDataSourceImpl1", response.toDomainList().toString())
//        Log.d("LocalDataSourceImpl2", response.toString())
        return try {
            val response = binDao.getAllBinInfoWithDetails()
            response.toDomainList()
        } catch (e: Exception) {
            throw RuntimeException("$e")
        }
    }
}