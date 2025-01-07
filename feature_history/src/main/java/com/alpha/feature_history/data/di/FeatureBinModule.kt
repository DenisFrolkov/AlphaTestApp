package com.alpha.feature_history.data.di

import com.alpha.core.domain.repository.BinHistoryRepository
import com.alpha.feature_history.domain.usecase.GetAllBinInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FeatureBinModule {

    @Provides
    @Singleton
    fun providesGetAllBinInfoUseCase(repository: BinHistoryRepository): GetAllBinInfoUseCase {
        return GetAllBinInfoUseCase(repository)
    }

}