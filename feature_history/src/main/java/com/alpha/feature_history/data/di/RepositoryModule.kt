package com.alpha.feature_history.data.di

import com.alpha.core.data.database.BinDao
import com.alpha.core.domain.source.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import com.alpha.core.domain.repository.BinHistoryRepository
import com.alpha.feature_history.data.repository.BinHistoryRepositoryImpl
import com.alpha.feature_history.data.source.LocalDataSourceImpl
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(
        dao: BinDao,
    ): LocalDataSource {
        return LocalDataSourceImpl(dao)
    }

    @Provides
    @Singleton
    fun provideBinInfoHistoryRepository(
        localDataSource: LocalDataSource,
    ): BinHistoryRepository {
        return BinHistoryRepositoryImpl(localDataSource)
    }
}