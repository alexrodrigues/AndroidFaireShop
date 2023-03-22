package com.faire.faireshop.features.home.repository

import com.faire.faireshop.features.home.data.FaireHomeRepository
import com.faire.faireshop.features.home.data.FaireHomeRepositoryImpl
import com.faire.faireshop.features.home.data.response.FaireHomeResponse
import com.faire.faireshop.features.home.data.service.FaireHomeService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test

class FaireHomeRepositoryTest {

    private lateinit var repository: FaireHomeRepository

    @MockK
    private lateinit var service: FaireHomeService

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = FaireHomeRepositoryImpl(service)
    }

    @Test
    fun `should fetch home`() {
        // Given
        val homeListMock = listOf(mockk<FaireHomeResponse>())
        every { service.getHome() } returns Single.just(homeListMock)

        // Then
        repository.getHome()
            .test()
            .assertComplete()
            .assertValue {
                // Should
                it == homeListMock
            }
    }

    @Test
    fun `should fail fetch home`() {
        // Given
        every { service.getHome() } returns Single.error(RuntimeException())

        // Then
        repository.getHome()
            .test()
            .assertNotComplete()
            .assertError {
                // Should
                it is RuntimeException
            }
    }
}