package com.alpha.feature_bin.data.mappers

import com.alpha.core.data.database.models.BankEntity
import com.alpha.core.models.BankDomain

object BankMapper {

    fun BankDomain.toEntity(): BankEntity {
        return BankEntity(
            city = city,
            name = name,
            phone = phone,
            url = url
        )
    }
}