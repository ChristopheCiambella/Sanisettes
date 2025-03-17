package eu.ciambella.sanisettes.present.common.mapper

import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SanisetteCardMapperTest {

    private lateinit var cut: SanisetteCardMapper

    @Before
    fun setUp() {
        cut = SanisetteCardMapper()
    }

    @Test
    fun `map returns correct SanisetteCardProperty`() {
        // Given
        val sanisette = mockk<Sanisette> {
            every { address } returns "123 Main St"
            every { openingHours } returns "8h - 20h"
            every { isPmr } returns true
            every { distance } returns "500m"
        }

        // When
        val property = cut.map(sanisette) {}

        // Then
        assertEquals("123 Main St", property.address)
        assertEquals("8h - 20h", property.openingHours)
        assertTrue(property.isPmr)
        assertEquals("500m", property.distance)
    }
}
