package com.alpha.feature_bin.data.mappers

import com.alpha.core.data.database.models.NumberEntity
import com.alpha.core.data.model.Number

object NumberMapper {

    fun Number.toEntity(): NumberEntity {
        return NumberEntity(
            length = length,
            luhn = luhn
        )
    }

}