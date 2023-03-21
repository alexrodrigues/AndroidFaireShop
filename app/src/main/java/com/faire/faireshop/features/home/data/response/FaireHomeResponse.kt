package com.faire.faireshop.features.home.data.response


data class FaireHomeResponse (
    val brandToken: String,
    val detailsText: String? = null,
    val productImage: String? = null,
    val productName: String? = null,
    val wholesalePrice: FairePriceResponse? = null
)