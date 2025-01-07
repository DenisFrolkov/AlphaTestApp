package com.alpha.core.data.model.mappers

import com.alpha.core.data.database.models.BinInfoWithDetailsEntity
import com.alpha.core.data.model.Bank
import com.alpha.core.data.model.BinInfo
import com.alpha.core.data.model.Country
import com.alpha.core.data.model.Number

object BinInfoWithDetailsMapper {
    private fun BinInfoWithDetailsEntity.toDomain(): BinInfo {
        return BinInfo(
            bin = binInfoEntity.bin,
            scheme = binInfoEntity.scheme,
            type = binInfoEntity.type,
            brand = binInfoEntity.brand,
            prepaid = binInfoEntity.prepaid,
            number = numberEntity?.let {
                Number(
                    length = it.length,
                    luhn = it.luhn
                )
            },
            country = countryEntity?.let {
                Country(
                    numeric = it.numeric,
                    alpha2 = it.alpha2,
                    name = it.name,
                    emoji = it.emoji,
                    currency = it.currency,
                    latitude = it.latitude,
                    longitude = it.longitude
                )
            },
            bank = bankEntity?.let {
                Bank(
                    name = it.name,
                    url = it.url,
                    phone = it.phone,
                    city = it.city
                )
            }
        )
    }

    fun List<BinInfoWithDetailsEntity>.toDomainList(): List<BinInfo> {
        return this.map { it.toDomain() }
    }
}