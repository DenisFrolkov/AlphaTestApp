package com.alpha.core.di

import android.app.Application
import androidx.room.Room
import com.alpha.core.data.database.AppDatabase
import com.alpha.core.data.database.BinDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "bin_database")
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(database: AppDatabase): BinDao {
        return database.binDao()
    }
}