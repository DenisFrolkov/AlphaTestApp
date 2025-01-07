package com.alpha.core.data.model

data class BinInfo(
    val bin: String? = null,
    val number: Number?,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean?,
    val country: Country?,
    val bank: Bank?,
)