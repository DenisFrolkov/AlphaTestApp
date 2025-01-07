package com.alpha.feature_bin.data.di

import android.content.Context
import com.alpha.core.data.network.ApiService
import com.alpha.core.domain.repository.BinRepository
import com.alpha.core.domain.repository.NetworkRepository
import com.alpha.core.domain.source.LocalDataSource
import com.alpha.core.domain.source.NetworkDataSource
import com.alpha.core.domain.source.RemoveDataSource
import com.alpha.feature_bin.data.repository.BinRepositoryImpl
import com.alpha.feature_bin.data.repository.NetworkRepositoryImpl
import com.alpha.feature_bin.data.source.NetworkDataSourceImpl
import com.alpha.feature_bin.data.source.RemoveDataSourceImpl
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
    fun provideBinInfoRepository(
        removeDataSource: RemoveDataSource,
        localDataSource: LocalDataSource
    ): BinRepository {
        return BinRepositoryImpl(removeDataSource, localDataSource)
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