package com.alpha.core.models

import com.google.gson.annotations.SerializedName

data class BankResponse(
    @SerializedName("city")
    val city: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("url")
    val url: String?
)