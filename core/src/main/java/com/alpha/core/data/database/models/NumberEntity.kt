package com.alpha.core.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "number")
data class NumberEntity(
    @PrimaryKey(autoGenerate = true) val nId: Long,
    @ColumnInfo(name = "length") val length: Int,
    @ColumnInfo(name = "luhn") val luhn: Boolean
)