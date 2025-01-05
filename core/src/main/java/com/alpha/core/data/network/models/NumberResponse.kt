package com.alpha.core.models

import com.google.gson.annotations.SerializedName

data class NumberResponse(
    @SerializedName("length")
    val length: Int?,
    @SerializedName("luhn")
    val luhn: Boolean?
)