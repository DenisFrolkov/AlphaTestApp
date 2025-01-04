package com.alpha.core.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true) val cId: Long,
    @ColumnInfo(name = "alpha2") val alpha2: String,
    @ColumnInfo(name = "currency") val currency: String,
    @ColumnInfo(name = "emoji") val emoji: String,
    @ColumnInfo(name = "latitude") val latitude: Int,
    @ColumnInfo(name = "longitude") val longitude: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "numeric") val numeric: String
)