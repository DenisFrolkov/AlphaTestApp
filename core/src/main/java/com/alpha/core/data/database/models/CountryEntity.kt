package com.alpha.core.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "country", indices = [Index(value = ["cId"], unique = true)],)
data class CountryEntity(
    @PrimaryKey(autoGenerate = true) val cId: Long = 0,
    @ColumnInfo(name = "alpha2") val alpha2: String?,
    @ColumnInfo(name = "currency") val currency: String?,
    @ColumnInfo(name = "emoji") val emoji: String?,
    @ColumnInfo(name = "latitude") val latitude: Int?,
    @ColumnInfo(name = "longitude") val longitude: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "numeric") val numeric: String?
)