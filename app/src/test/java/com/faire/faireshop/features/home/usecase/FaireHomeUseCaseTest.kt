package com.faire.faireshop.features.home.usecase

import com.faire.faireshop.features.home.data.FaireHome
import com.faire.faireshop.features.home.data.FaireHomeRepository
import com.faire.faireshop.features.home.data.response.FaireHomeResponse
import com.faire.faireshop.features.home.domain.FaireHomeMapper
import com.faire.faireshop.features.home.domain.FaireHomeUseCase
import com.faire.faireshop.features.home.domain.FaireHomeUseCaseImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test

class FaireHomeUseCaseTest {


    private lateinit var useCase: FaireHomeUseCase

    @MockK
    private lateinit var repository: FaireHomeRepository

    @MockK
    private lateinit var mapper: FaireHomeMapper

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        useCase = FaireHomeUseCaseImpl(repository, mapper)
    }


    @Test
    fun `should fetch home with success`() {
        // Given
        val response = listOf(mockk<FaireHomeResponse>())
        val businessModel = mockk<FaireHome>()
        every { repository.getHome() } returns Single.just(response)
        every { mapper.transform(response.first()) } returns businessModel

        // Then
        useCase()
            .test()
            .assertComplete()
            .assertValue {
                // Should
                it.first() == businessModel
            }
    }

    @Test
    fun `should fail fetch home with success`() {
        // Given
        val response = listOf(mockk<FaireHomeResponse>())
        val businessModel = mockk<FaireHome>()
        every { repository.getHome() } returns Single.error(RuntimeException())
        every { mapper.transform(response.first()) } returns businessModel

        // Then
        useCase()
            .test()
            .assertNotComplete()
            .assertError {
                // Should
                it is RuntimeException
            }
    }
}