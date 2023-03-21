package com.faire.faireshop.features.home.data


data class FaireHome (
    val brandToken: String,
    val detailsText: String,
    val productImage: String?,
    val productName: String,
    val wholesalePriceFormatted: String? = null
)