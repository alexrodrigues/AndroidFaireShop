package com.faire.faireshop.features.home.uimapper

import com.faire.faireshop.features.home.data.FaireHome
import com.faire.faireshop.features.home.data.response.FaireHomeResponse
import com.faire.faireshop.features.home.presentation.uimapper.FaireHomeUiMapper
import com.faire.faireshop.features.home.presentation.uimapper.FaireHomeUiMapperImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class FaireHomeUiMapperTest {

    private lateinit var mapper: FaireHomeUiMapper

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        mapper = FaireHomeUiMapperImpl()
    }

    @Test
    fun `given an api model should transform into an business model`() {
        // Given
        val businessModel = mockk<FaireHome>(relaxed = true) {
            every { productName } returns "FAIRE_NAME"
        }

        // Then
        val uiModel = mapper.transform(businessModel)

        // Should
        assertEquals(uiModel.productName, businessModel.productName)
    }

}