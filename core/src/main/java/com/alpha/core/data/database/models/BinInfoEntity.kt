package com.alpha.core.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "bin_info", foreignKeys = [
        ForeignKey(
            entity = NumberEntity::class,
            parentColumns = ["cId"],
            childColumns = ["countryId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CountryEntity::class,
            parentColumns = ["Id"],
            childColumns = ["countryId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BankEntity::class,
            parentColumns = ["bId"],
            childColumns = ["bankId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BinInfoEntity(
    @PrimaryKey(autoGenerate = true) val bId: Int,
    @ColumnInfo(name = "numberId") val numberId: Long,
    @ColumnInfo(name = "scheme") val scheme: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "brand") val brand: String,
    @ColumnInfo(name = "prepaid") val prepaid: Boolean,
    @ColumnInfo(name = "countryId") val countryId: Long,
    @ColumnInfo(name = "bankId") val bankId: Long,
)