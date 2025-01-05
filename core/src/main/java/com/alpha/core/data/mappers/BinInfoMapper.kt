package com.alpha.feature_bin.data.mappers

import com.alpha.core.data.database.models.BinInfoEntity
import com.alpha.core.models.BankDomain
import com.alpha.core.models.BinInfoDomain
import com.alpha.core.models.BinInfoResponse
import com.alpha.core.models.CountryDomain
import com.alpha.core.models.NumberDomain

object BinInfoMapper {

    fun BinInfoDomain.toEntity(): BinInfoEntity {
        return BinInfoEntity(
            numberId = 0,
            scheme = scheme,
            type = type,
            brand = brand,
            prepaid = prepaid,
            countryId = 0,
            bankId = 0,
        )
    }

    fun BinInfoResponse.toDomain(): BinInfoDomain {
        return BinInfoDomain(
            numberDomain = NumberDomain(
                length = numberResponse.length,
                luhn = numberResponse.luhn,
            ),
            scheme = scheme,
            type = type,
            brand = brand,
            prepaid = prepaid,
            countryDomain = CountryDomain(
                numeric = countryResponse.numeric,
                alpha2 = countryResponse.alpha2,
                name = countryResponse.name,
                emoji = countryResponse.emoji,
                currency = countryResponse.currency,
                latitude = countryResponse.latitude,
                longitude = countryResponse.longitude,
            ),
            bankDomain = BankDomain(
                name = bankResponse.name,
                url = bankResponse.url,
                phone = bankResponse.phone,
                city = bankResponse.city,
            ),
        )
    }
}