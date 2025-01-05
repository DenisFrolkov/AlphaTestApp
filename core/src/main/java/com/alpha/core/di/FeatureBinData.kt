package com.alpha.core.di

import com.alpha.core.repository.BinInfoHistoryRepository
import com.alpha.core.repository.BinInfoRepositoryImpl
import com.alpha.feature_bin.data.source.BinInfoDataSource
import com.alpha.feature_bin.domain.repository.BinInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FeatureBinData {
    @Provides
    fun provideBinInfoDataSource(impl: BinInfoDataSource): BinInfoDataSource {
        return impl
    }

    @Provides
    fun provideBinInfoRepository(rep: BinInfoRepository): BinInfoRepository {
        return rep
    }

    @Provides
    fun provideBinInfoHistoryRepository(rep: BinInfoHistoryRepository): BinInfoHistoryRepository {
        return rep
    }
}