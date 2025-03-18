package eu.ciambella.sanisettes.present.common.mapper

import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MarkerPropertyMapperTest {

    private lateinit var cut: MarkerPropertyMapper

    @Before
    fun setUp() {
        cut = MarkerPropertyMapper()
    }

    @Test
    fun `map returns correct MarkerProperty`() {
        // Given
        val sanisette = mockk<Sanisette> {
            every { address } returns "Test Address"
            every { location } returns mockk<Location> {
                every { latitude } returns 48.8566
                every { longitude } returns 2.3522
            }
        }

        // When
        val markerProperty = cut.map(sanisette) {}

        // Then
        assertEquals(48.8566, markerProperty.latitude, 0.0001)
        assertEquals(2.3522, markerProperty.longitude, 0.0001)
        assertEquals("Test Address", markerProperty.title)
    }
}
