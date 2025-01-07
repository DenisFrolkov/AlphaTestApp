package com.alpha.core.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "bin_info", foreignKeys = [
        ForeignKey(
            entity = NumberEntity::class,
            parentColumns = ["nId"],
            childColumns = ["numberId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CountryEntity::class,
            parentColumns = ["cId"],
            childColumns = ["countryId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BankEntity::class,
            parentColumns = ["bId"],
            childColumns = ["bankId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["binNumber"], unique = true), Index(value = ["countryId"]), Index(value = ["bankId"]), Index(value = ["numberId"])]
)
data class BinInfoEntity(
    @PrimaryKey(autoGenerate = true) val bId: Long = 0,
    @ColumnInfo(name = "binNumber") val bin: String?,
    @ColumnInfo(name = "numberId") val numberId: Long?,
    @ColumnInfo(name = "scheme") val scheme: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "brand") val brand: String,
    @ColumnInfo(name = "prepaid") val prepaid: Boolean?,
    @ColumnInfo(name = "countryId") val countryId: Long?,
    @ColumnInfo(name = "bankId") val bankId: Long?,
)