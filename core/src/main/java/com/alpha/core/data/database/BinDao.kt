package com.alpha.core.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.alpha.core.data.database.models.BankEntity
import com.alpha.core.data.database.models.BinInfoEntity
import com.alpha.core.data.database.models.BinInfoWithDetailsEntity
import com.alpha.core.data.database.models.CountryEntity
import com.alpha.core.data.database.models.NumberEntity

@Dao
interface BinDao {
    @Insert
    suspend fun insertNumber(number: NumberEntity): Long

    @Insert
    suspend fun insertCountry(country: CountryEntity): Long

    @Insert
    suspend fun insertBank(bank: BankEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBinInfo(binInfo: BinInfoEntity)

    @Transaction
    suspend fun insertFullData(
        binInfo: BinInfoEntity,
        number: NumberEntity?,
        country: CountryEntity?,
        bank: BankEntity?
    ) {
        val numberId = if (number?.luhn != null || number?.length != null) {
            insertNumber(number)
        } else {
            null
        }
        val countryId = country?.let { insertCountry(it) }
        val backId = bank?.let { insertBank(it) }
        insertBinInfo(binInfo.copy(numberId = numberId, countryId = countryId, bankId = backId))
    }

    @Transaction
    @Query("SELECT * FROM bin_info WHERE bId = :binId")
    suspend fun getBinInfoWithDetails(binId: Int): BinInfoWithDetailsEntity

    @Transaction
    @Query("SELECT * FROM bin_info")
    suspend fun getAllBinInfoWithDetails(): List<BinInfoWithDetailsEntity>
}