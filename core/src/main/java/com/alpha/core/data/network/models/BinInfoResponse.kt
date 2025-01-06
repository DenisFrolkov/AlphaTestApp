package com.alpha.core.models

import com.google.gson.annotations.SerializedName

data class BinInfoResponse(
    @SerializedName("number")
    val numberResponse: NumberResponse?,
    @SerializedName("scheme")
    val scheme: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("prepaid")
    val prepaid: Boolean?,
    @SerializedName("country")
    val countryResponse: CountryResponse?,
    @SerializedName("bank")
    val bankResponse: BankResponse?,
)