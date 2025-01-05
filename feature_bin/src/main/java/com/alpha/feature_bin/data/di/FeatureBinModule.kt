package com.alpha.feature_bin.data.di

import com.alpha.core.repository.BinInfoHistoryRepository
import com.alpha.core.repository.BinInfoRepository
import com.alpha.feature_bin.domain.usecases.GetBinInfoUseCase
import com.alpha.feature_bin.domain.usecases.SaveBinInfoUseCase
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
    fun providesGetBinInfoUseCase(repository: BinInfoRepository): GetBinInfoUseCase {
        return GetBinInfoUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesSaveBinInfoUseCase(repository: BinInfoHistoryRepository): SaveBinInfoUseCase {
        return SaveBinInfoUseCase(repository)
    }

}