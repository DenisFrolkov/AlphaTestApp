package com.alpha.feature_bin.data.mappers

import com.alpha.core.data.database.models.BankEntity
import com.alpha.core.data.model.Bank

object BankMapper {

    fun Bank.toEntity(): BankEntity {
        return BankEntity(
            city = city,
            name = name,
            phone = phone,
            url = url
        )
    }
}