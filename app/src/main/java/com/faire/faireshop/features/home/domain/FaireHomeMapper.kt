package com.faire.faireshop.features.home.domain

import com.faire.faireshop.features.home.data.FaireHome
import com.faire.faireshop.features.home.data.response.FaireHomeResponse
import java.text.DecimalFormat

interface FaireHomeMapper {
    fun transform(response: FaireHomeResponse): FaireHome
}

class FaireHomeMapperImpl: FaireHomeMapper {

    override fun transform(response: FaireHomeResponse): FaireHome =
        FaireHome(
            brandToken = response.brandToken,
            detailsText = response.detailsText.orEmpty(),
            productImage = response.productImage,
            productName = response.productName.orEmpty(),
            wholesalePriceFormatted = with(DecimalFormat("'\$'#,###.##")) {
                format(response.wholesalePrice?.price)
            }
        )
}