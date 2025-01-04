package com.alpha.core.data.database.models

import androidx.room.Embedded
import androidx.room.Relation

data class BinInfoWithDetails(
    @Embedded val binInfoEntity: BinInfoEntity,
    @Relation(
        parentColumn = "nId",
        entityColumn = "numberId"
    )
    val numberEntity: NumberEntity,

    @Relation(
        parentColumn = "cId",
        entityColumn = "countryId"
    )
    val countryEntity: CountryEntity,

    @Relation(
        parentColumn = "bId",
        entityColumn = "bankId"
    )
    val bankEntity: BankEntity
)