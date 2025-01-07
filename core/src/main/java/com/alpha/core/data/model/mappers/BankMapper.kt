package com.alpha.core.data.model.mappers

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