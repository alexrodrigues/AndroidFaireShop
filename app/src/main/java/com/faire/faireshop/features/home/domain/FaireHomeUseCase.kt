package com.faire.faireshop.features.home.domain

import com.faire.faireshop.features.home.data.FaireHome
import com.faire.faireshop.features.home.data.FaireHomeRepository
import com.faire.faireshop.features.home.data.response.FaireHomeResponse
import io.reactivex.rxjava3.core.Single

interface FaireHomeUseCase {
    operator fun invoke(): Single<List<FaireHome>>
}

class FaireHomeUseCaseImpl(
    private val repository: FaireHomeRepository,
    private val mapper: FaireHomeMapper
): FaireHomeUseCase {

    override fun invoke(): Single<List<FaireHome>> =
        repository.getHome()
            .map { list ->
                list.map { mapper.transform(it) }
            }

}
