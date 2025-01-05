package com.alpha.core.models

data class BinInfoDomain(
    val numberDomain: NumberDomain,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val countryDomain: CountryDomain,
    val bankDomain: BankDomain,
)