package com.faire.faireshop.features.home.presentation.uimapper

import com.faire.faireshop.components.fairelist.viewobject.FaireProductItemVO
import com.faire.faireshop.features.home.data.FaireHome

interface FaireHomeUiMapper {
    fun transform(model: FaireHome): FaireProductItemVO
}

class FaireHomeUiMapperImpl: FaireHomeUiMapper {

    override fun transform(model: FaireHome): FaireProductItemVO =
        FaireProductItemVO(
            productName = model.productName,
            productDescription = model.detailsText,
            productImage = model.productImage,
            wholesalePrice = model.wholesalePriceFormatted.orEmpty()
        )

}