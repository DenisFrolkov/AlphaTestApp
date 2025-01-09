package com.alpha.core.data.database.models

import androidx.room.Embedded
import androidx.room.Relation

data class BinInfoWithDetailsEntity(
    @Embedded val binInfoEntity: BinInfoEntity,
    @Relation(
        parentColumn = "numberId",
        entityColumn = "nId"
    )
    val numberEntity: NumberEntity?,

    @Relation(
        parentColumn = "countryId",
        entityColumn = "cId"
    )
    val countryEntity: CountryEntity?,

    @Relation(
        parentColumn = "bankId",
        entityColumn = "bId"
    )
    val bankEntity: BankEntity?
)