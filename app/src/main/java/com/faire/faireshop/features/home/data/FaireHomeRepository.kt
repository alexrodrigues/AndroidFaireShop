package com.faire.faireshop.features.home.data

import com.faire.faireshop.features.home.data.response.FaireHomeResponse
import com.faire.faireshop.features.home.data.service.FaireHomeService
import io.reactivex.rxjava3.core.Single

interface FaireHomeRepository {
    fun getHome(): Single<List<FaireHomeResponse>>
}

class FaireHomeRepositoryImpl(
    private val api: FaireHomeService
): FaireHomeRepository {
    override fun getHome(): Single<List<FaireHomeResponse>> = api.getHome()
}