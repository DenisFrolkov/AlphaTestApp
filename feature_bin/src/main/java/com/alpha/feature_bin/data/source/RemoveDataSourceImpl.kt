package com.alpha.feature_bin.data.source

import com.alpha.core.data.model.BinInfo
import com.alpha.core.data.network.ApiService
import com.alpha.core.data.model.mappers.BinInfoMapper.toDomain
import com.alpha.feature_bin.domain.datasource.BinRemoveDataSource
import javax.inject.Inject

class BinRemoveDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : BinRemoveDataSource {

    override suspend fun getBinInfo(bin: String): BinInfo {
        val response = apiService.getBinInfo(bin)
        return try {
            response.toDomain()
        } catch (e: Exception) {
            throw RuntimeException("Ошибка загрузки BIN информации: $e")
        }
    }
}