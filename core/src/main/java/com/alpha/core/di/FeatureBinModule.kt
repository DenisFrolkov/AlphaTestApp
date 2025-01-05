package com.alpha.core.di

import com.alpha.feature_bin.data.source.BinInfoDataSource
import com.alpha.feature_bin.domain.usecases.GetBinInfoUseCase
import com.alpha.feature_bin.domain.usecases.SaveBinInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FeatureBinModule {

    @Provides
    fun providesGetBinInfoUseCase(repository: BinInfoDataSource): GetBinInfoUseCase {
        return GetBinInfoUseCase(repository)
    }

    @Provides
    fun providesSaveBinInfoUseCase(repository: BinInfoDataSource): SaveBinInfoUseCase {
        return SaveBinInfoUseCase(repository)
    }
}