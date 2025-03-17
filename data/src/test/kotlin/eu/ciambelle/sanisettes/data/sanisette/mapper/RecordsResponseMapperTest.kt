package eu.ciambelle.sanisettes.data.sanisette.mapper

import eu.ciambella.sanisettes.data.network.response.RecordsResponse
import eu.ciambella.sanisettes.data.sanisette.mapper.RecordsResponseMapper
import eu.ciambella.sanisettes.data.sanisette.mapper.SanisetteMapper
import eu.ciambella.sanisettes.domain.location.model.Location
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class RecordsResponseMapperTest {

    @MockK
    private lateinit var sanisetteMapper: SanisetteMapper

    private lateinit var cut: RecordsResponseMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        cut = RecordsResponseMapper(sanisetteMapper)
    }

    @Test
    fun `map returns empty list and null nextOffset when response is empty`() {
        // Given
        val response = mockk<RecordsResponse> {
            every { results } returns emptyList()
            every { totalCount } returns 0
        }
        val currentLocation: Location? = null
        val offset = 0

        // When
        val result = cut.map(response, currentLocation, offset)

        // Then
        assertTrue(result.sanisettes.isEmpty())
        assertNull(result.nextOffset)
    }

    @Test
    fun `map calculates nextOffset correctly when not exceeding total count`() {
        // Given
        val response = mockk<RecordsResponse> {
            every { results } returns listOf(mockk(), mockk())
            every { totalCount } returns 5
        }
        val currentLocation: Location? = null
        val offset = 0

        // When
        val result = cut.map(response, currentLocation, offset)

        // Then
        assertEquals(2, result.sanisettes.size)
        assertEquals(2, result.nextOffset)
    }

    @Test
    fun `map returns null nextOffset when computed offset equals or exceeds total count`() {
        // Given
        val response = mockk<RecordsResponse> {
            every { results } returns listOf(mockk(), mockk(), mockk())
            every { totalCount } returns 5
        }
        val currentLocation: Location? = null
        val offset = 2

        // When
        val result = cut.map(response, currentLocation, offset)

        // Then
        assertEquals(3, result.sanisettes.size)
        assertNull(result.nextOffset)
    }

    @Test
    fun `map filters out null values from the mapper`() {
        // Given
        val response = mockk<RecordsResponse> {
            every { results } returns listOf(mockk(), mockk(), mockk(), mockk(), mockk())
            every { totalCount } returns 10
        }
        val currentLocation: Location? = null
        val offset = 0

        // When
        val result = cut.map(response, currentLocation, offset)

        // Then
        assertEquals(2, result.sanisettes.size)
        assertEquals(4, result.nextOffset)
    }
}
