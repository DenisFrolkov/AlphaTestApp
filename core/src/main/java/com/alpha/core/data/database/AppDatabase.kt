package com.alpha.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alpha.core.data.database.models.BankEntity
import com.alpha.core.data.database.models.BinInfoEntity
import com.alpha.core.data.database.models.CountryEntity
import com.alpha.core.data.database.models.NumberEntity

@Database(entities = [BinInfoEntity::class, NumberEntity::class, BankEntity::class, CountryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun binDao(): BinDao
}