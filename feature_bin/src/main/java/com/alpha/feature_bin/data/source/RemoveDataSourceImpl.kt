package com.alpha.feature_bin.data.source

import com.alpha.core.data.model.BinInfo
import com.alpha.core.data.network.ApiService
import com.alpha.feature_bin.data.mappers.BinInfoMapper.toDomain
import com.alpha.core.source.RemoveDataSource
import javax.inject.Inject

class RemoveDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoveDataSource {

    override suspend fun getBinInfo(bin: String): BinInfo {
        val response = apiService.getBinInfo(bin)

        return try {
            response.toDomain()
        } catch (e: Exception) {
            throw RuntimeException("Ошибка загрузки BIN информации: $e")
        }
    }
}