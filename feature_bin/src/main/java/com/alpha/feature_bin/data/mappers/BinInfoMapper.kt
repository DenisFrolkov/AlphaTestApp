package com.alpha.feature_bin.data.mappers

import com.alpha.core.data.database.models.BinInfoEntity
import com.alpha.core.data.model.Bank
import com.alpha.core.data.model.BinInfo
import com.alpha.core.data.model.Country
import com.alpha.core.data.model.Number
import com.alpha.core.models.BinInfoResponse

object BinInfoMapper {

    fun BinInfo.toEntity(): BinInfoEntity {
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

    fun BinInfoResponse.toDomain(): BinInfo {
        return BinInfo(
            number = Number(
                length = numberResponse?.length,
                luhn = numberResponse?.luhn,
            ),
            scheme = scheme,
            type = type,
            brand = brand,
            prepaid = prepaid,
            country = Country(
                numeric = countryResponse?.numeric,
                alpha2 = countryResponse?.alpha2,
                name = countryResponse?.name,
                emoji = countryResponse?.emoji,
                currency = countryResponse?.currency,
                latitude = countryResponse?.latitude,
                longitude = countryResponse?.longitude,
            ),
            bank = Bank(
                name = bankResponse?.name,
                url = bankResponse?.url,
                phone = bankResponse?.phone,
                city = bankResponse?.city,
            ),
        )
    }
}