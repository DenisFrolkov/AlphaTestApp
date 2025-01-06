package com.alpha.feature_bin.data.di

import android.content.Context
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
import com.alpha.core.repository.NetworkRepository
import com.alpha.core.source.NetworkDataSource
import com.alpha.feature_bin.data.repository.NetworkRepositoryImpl
import com.alpha.feature_bin.data.source.NetworkDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    fun provideNetworkDataSource(
        @ApplicationContext context: Context
    ): NetworkDataSource {
        return NetworkDataSourceImpl(context)
    }

    @Provides
    @Singleton
    fun provideNetworkRepository(
        networkDataSource: NetworkDataSource
    ): NetworkRepository {
        return NetworkRepositoryImpl(networkDataSource)
    }
}