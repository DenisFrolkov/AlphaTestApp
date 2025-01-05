package com.alpha.feature_bin.data.mappers

import com.alpha.core.data.database.models.NumberEntity
import com.alpha.core.models.NumberDomain

object NumberMapper {

    fun NumberDomain.toEntity(): NumberEntity {
        return NumberEntity(
            length = length,
            luhn = luhn
        )
    }

}