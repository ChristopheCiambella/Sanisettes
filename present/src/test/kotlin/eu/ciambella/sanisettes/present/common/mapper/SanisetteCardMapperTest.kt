package eu.ciambella.sanisettes.present.common.mapper

import android.content.Context
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SanisetteCardMapperTest {

    @MockK
    private lateinit var context: Context

    private lateinit var cut: SanisetteCardMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        cut = SanisetteCardMapper(context)
    }

    @Test
    fun `map returns correct SanisetteCardProperty with distance less than 1000`() {
        // Given
        val sanisette = mockk<Sanisette> {
            every { address } returns "123 Main St"
            every { openingHours } returns "8h - 20h"
            every { isPmr } returns true
            every { distanceInMeter } returns 500.0
        }

        // When
        val property = cut.map(sanisette) {}

        // Then
        assertEquals("123 Main St", property.address)
        assertEquals("8h - 20h", property.openingHours)
        assertTrue(property.isPmr)
        assertEquals("500m", property.distance)
    }

    @Test
    fun `map returns correct SanisetteCardProperty with distance more than 1000`() {
        // Given
        val sanisette = mockk<Sanisette> {
            every { address } returns "123 Main St"
            every { openingHours } returns "8h - 20h"
            every { isPmr } returns false
            every { distanceInMeter } returns 1500.0
        }

        // When
        val property = cut.map(sanisette) {}

        // Then
        assertEquals("123 Main St", property.address)
        assertEquals("8h - 20h", property.openingHours)
        assertFalse(property.isPmr)
        assertEquals("1,500km", property.distance)
    }
}
