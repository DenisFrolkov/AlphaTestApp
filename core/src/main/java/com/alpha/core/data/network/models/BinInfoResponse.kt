package com.alpha.core.models

data class BinInfoResponse(
    val numberResponse: NumberResponse,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val countryResponse: CountryResponse,
    val bankResponse: BankResponse,
)