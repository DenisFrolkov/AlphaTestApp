package com.alpha.core.models

import com.alpha.core.data.database.models.BankEntity
import com.alpha.core.data.database.models.CountryEntity
import com.alpha.core.data.database.models.NumberEntity

data class BinInfoResponse(
    val numberEntity: NumberEntity,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val countryEntity: CountryEntity,
    val bankEntity: BankEntity,
)