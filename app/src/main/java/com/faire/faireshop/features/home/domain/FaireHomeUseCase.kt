package com.faire.faireshop.features.home.domain

import com.faire.faireshop.features.home.data.FaireHomeRepository
import com.faire.faireshop.features.home.data.response.FaireHomeResponse
import io.reactivex.rxjava3.core.Single

interface FaireHomeUseCase {
    operator fun invoke(): Single<List<FaireHomeResponse>>
}

class FaireHomeUseCaseImpl(
    private val repository: FaireHomeRepository
): FaireHomeUseCase {

    override fun invoke(): Single<List<FaireHomeResponse>> = repository.getHome()

}
