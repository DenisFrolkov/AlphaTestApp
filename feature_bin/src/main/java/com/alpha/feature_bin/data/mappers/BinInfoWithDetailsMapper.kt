package com.alpha.feature_bin.data.mappers

import com.alpha.core.data.database.models.BinInfoWithDetailsEntity
import com.alpha.core.data.model.Bank
import com.alpha.core.data.model.BinInfo
import com.alpha.core.data.model.Country
import com.alpha.core.data.model.Number

object BinInfoWithDetailsMapper {
    fun BinInfoWithDetailsEntity.toDomain(): BinInfo {
        return BinInfo(
                number = Number(
                    length = numberEntity.length,
                    luhn = numberEntity.luhn,
                ),
                scheme = binInfoEntity.scheme,
                type = binInfoEntity.type,
                brand = binInfoEntity.brand,
                prepaid = binInfoEntity.prepaid,
                country = Country(
                    numeric = countryEntity.numeric,
                    alpha2 = countryEntity.alpha2,
                    name = countryEntity.name,
                    emoji = countryEntity.emoji,
                    currency = countryEntity.currency,
                    latitude = countryEntity.latitude,
                    longitude = countryEntity.longitude,
                ),
                bank = Bank(
                    name = bankEntity.name,
                    url = bankEntity.url,
                    phone = bankEntity.phone,
                    city = bankEntity.city,
                ),
            )
    }

    fun List<BinInfoWithDetailsEntity>.toDomainList(): List<BinInfo> {
        return this.map { it.toDomain() }
    }
}