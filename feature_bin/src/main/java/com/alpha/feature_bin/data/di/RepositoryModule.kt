package com.alpha.feature_bin.data.di

import android.content.Context
import com.alpha.core.data.database.BinDao
import com.alpha.core.data.network.ApiService
import com.alpha.feature_bin.domain.repository.BinRepository
import com.alpha.core.domain.repository.NetworkRepository
import com.alpha.core.domain.source.NetworkDataSource
import com.alpha.feature_bin.data.repository.BinRepositoryImpl
import com.alpha.feature_bin.data.repository.NetworkRepositoryImpl
import com.alpha.feature_bin.data.source.BinLocalDataSourceImpl
import com.alpha.feature_bin.data.source.BinRemoveDataSourceImpl
import com.alpha.feature_bin.data.source.NetworkDataSourceImpl
import com.alpha.feature_bin.domain.datasource.BinLocalDataSource
import com.alpha.feature_bin.domain.datasource.BinRemoveDataSource
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
    fun provideBinLocalDataSource(
        binDao: BinDao,
    ): BinLocalDataSource {
        return BinLocalDataSourceImpl(binDao)
    }

    @Provides
    @Singleton
    fun provideBinRemoveDataSource(
        apiService: ApiService,
    ): BinRemoveDataSource {
        return BinRemoveDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideBinInfoRepository(
        binLocalDataSource: BinLocalDataSource,
        binRemoveDataSource: BinRemoveDataSource
    ): BinRepository {
        return BinRepositoryImpl(binRemoveDataSource, binLocalDataSource)
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