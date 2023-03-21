package com.faire.faireshop.features.home.data.service

import com.faire.faireshop.features.home.data.response.FaireHomeResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface FaireHomeService {
    @GET("/static/mobile-take-home/products-response.json")
    fun getHome(): Single<List<FaireHomeResponse>>
}