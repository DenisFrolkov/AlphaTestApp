package com.alpha.feature_history.data.di

import com.alpha.core.data.database.BinDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import com.alpha.feature_history.data.repository.HistoryBinRepositoryImpl
import com.alpha.feature_history.data.source.HistoryBinLocalDataSourceImpl
import com.alpha.feature_history.domain.datasource.HistoryBinLocalDataSource
import com.alpha.feature_history.domain.repository.HistoryBinLocalRepository
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideHistoryBinLocalDataSource(
        dao: BinDao,
    ): HistoryBinLocalDataSource {
        return HistoryBinLocalDataSourceImpl(dao)
    }

    @Provides
    @Singleton
    fun provideHistoryBinRepository(
        historyBinLocalDataSource: HistoryBinLocalDataSource,
    ): HistoryBinLocalRepository {
        return HistoryBinRepositoryImpl(historyBinLocalDataSource)
    }
}