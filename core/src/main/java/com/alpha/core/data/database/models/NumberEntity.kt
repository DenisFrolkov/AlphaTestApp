package com.alpha.core.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "number", indices = [Index(value = ["nId"], unique = true)])
data class NumberEntity(
    @PrimaryKey(autoGenerate = true) val nId: Long = 0,
    @ColumnInfo(name = "length") val length: Int?,
    @ColumnInfo(name = "luhn") val luhn: Boolean?
)