package com.alpha.feature_bin.data.mappers

import com.alpha.core.data.database.models.CountryEntity
import com.alpha.core.data.model.Country

object CountryMapper {

    fun Country.toEntity(): CountryEntity {
        return CountryEntity(
            numeric = numeric,
            alpha2 = alpha2,
            name = name,
            currency = currency,
            latitude = latitude,
            longitude = longitude,
            emoji = emoji
        )
    }

}