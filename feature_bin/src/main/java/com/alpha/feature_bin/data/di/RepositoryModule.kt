package com.alpha.feature_bin.data.di

import com.alpha.core.data.database.BinDao
import com.alpha.core.data.network.ApiService
import com.alpha.feature_bin.data.repository.BinInfoHistoryRepositoryImpl
import com.alpha.feature_bin.data.repository.BinInfoRepositoryImpl
import com.alpha.core.source.LocalDataSource
import com.alpha.core.source.RemoveDataSource
import com.alpha.feature_bin.data.source.LocalDataSourceImpl
import com.alpha.feature_bin.data.source.RemoveDataSourceImpl
import com.alpha.core.repository.BinInfoHistoryRepository
import com.alpha.core.repository.BinInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRemoveDataSource(
        apiService: ApiService,
    ): RemoveDataSource {
        return RemoveDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        dao: BinDao,
    ): LocalDataSource {
        return LocalDataSourceImpl(dao)
    }

    @Provides
    @Singleton
    fun provideBinInfoRepository(
        removeDataSource: RemoveDataSource,
    ): BinInfoRepository {
        return BinInfoRepositoryImpl(removeDataSource)
    }

    @Provides
    @Singleton
    fun provideBinInfoHistoryRepository(
        localDataSource: LocalDataSource,
    ): BinInfoHistoryRepository {
        return BinInfoHistoryRepositoryImpl(localDataSource)
    }
}