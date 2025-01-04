package com.alpha.core.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.alpha.core.data.database.models.BankEntity
import com.alpha.core.data.database.models.BinInfoEntity
import com.alpha.core.data.database.models.BinInfoWithDetails
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

    @Insert
    suspend fun insertBinInfo(binInfo: BinInfoEntity)

    @Transaction
    suspend fun insertFullData(
        binInfo: BinInfoEntity,
        number: NumberEntity,
        country: CountryEntity,
        bank: BankEntity
    ) {
        val numberId = insertNumber(number)
        val countryId = insertCountry(country)
        val backId = insertBank(bank)
        insertBinInfo(binInfo.copy(numberId = numberId, countryId = countryId, bankId = backId))
    }

    @Transaction
    @Query("SELECT * FROM bin_info WHERE bId = :binId")
    suspend fun getBinInfoWithDetails(binId: Int): BinInfoWithDetails

    @Transaction
    @Query("SELECT * FROM bin_info")
    suspend fun getAllBinInfoWithDetails(): List<BinInfoWithDetails>
}