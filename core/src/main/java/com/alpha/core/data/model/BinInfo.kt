package com.alpha.core.data.model

data class BinInfo(
    val bin: String? = null,
    val number: Number? = null,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean? = null,
    val country: Country? = null,
    val bank: Bank? = null,
)