package com.faire.faireshop.features.home.mapper

import com.faire.faireshop.features.home.data.response.FaireHomeResponse
import com.faire.faireshop.features.home.domain.FaireHomeMapper
import com.faire.faireshop.features.home.domain.FaireHomeMapperImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class FaireHomeMapperTest {

    private lateinit var mapper: FaireHomeMapper

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        mapper = FaireHomeMapperImpl()
    }

    @Test
    fun `given an api model should transform into an business model`() {
        // Given
        val mockApiModel = mockk<FaireHomeResponse>(relaxed = true) {
            every { brandToken } returns "FAIRE_TOKEN"
        }

        // Then
        val businessModel = mapper.transform(mockApiModel)

        // Should
        assertEquals(mockApiModel.brandToken, businessModel.brandToken)
    }
}