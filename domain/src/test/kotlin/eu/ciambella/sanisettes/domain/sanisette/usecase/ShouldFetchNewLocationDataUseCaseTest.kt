package eu.ciambella.sanisettes.domain.sanisette.usecase

import eu.ciambella.sanisettes.domain.location.model.Location
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ShouldFetchNewLocationDataUseCaseTest {

    private lateinit var cut: ShouldFetchNewLocationDataUseCase

    @Before
    fun setup() {
        cut = ShouldFetchNewLocationDataUseCase()
    }

    @Test
    fun `should return true when previous location is null`() {
        // Given
        val newLocation = mockk<Location>()

        // When
        val result = cut.invoke(
            previousLocation = null,
            newLocation = newLocation
        )

        // Then
        assertTrue(result)
    }

    @Test
    fun `should return false when distance is below threshold`() {
        // Given
        val previousLocation = mockk<Location> {
            every { latitude } returns 48.8566
            every { longitude } returns 2.3522
        }
        val nearLocation = mockk<Location> {
            every { latitude } returns 48.8576
            every { longitude } returns 2.3522
        }

        // When
        val result = cut.invoke(
            previousLocation = previousLocation,
            newLocation = nearLocation
        )

        // Then
        assertFalse(result)
    }

    @Test
    fun `should return true when distance is above threshold`() {
        // Given
        val previousLocation = mockk<Location> {
            every { latitude } returns 48.8566
            every { longitude } returns 2.3522
        }
        val distantLocation = mockk<Location> {
            every { latitude } returns 48.8666
            every { longitude } returns 2.3522
        }

        // When
        val result = cut.invoke(
            previousLocation = previousLocation,
            newLocation = distantLocation
        )

        // Then
        assertTrue(result)
    }
}
