package com.alpha.feature_bin.data.di

import com.alpha.core.domain.repository.BinHistoryRepository
import com.alpha.core.domain.repository.BinRepository
import com.alpha.core.domain.repository.NetworkRepository
import com.alpha.feature_bin.domain.usecases.CheckInternetUseCase
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
    fun providesGetBinInfoUseCase(repository: BinRepository): GetBinInfoUseCase {
        return GetBinInfoUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesSaveBinInfoUseCase(repository: BinRepository): SaveBinInfoUseCase {
        return SaveBinInfoUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesCheckInternetUseCase(repository: NetworkRepository): CheckInternetUseCase {
        return CheckInternetUseCase(repository)
    }

}