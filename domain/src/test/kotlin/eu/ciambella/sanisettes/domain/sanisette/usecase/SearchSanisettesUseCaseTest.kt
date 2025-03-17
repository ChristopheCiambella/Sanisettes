package eu.ciambella.sanisettes.domain.sanisette.usecase

import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.sanisette.SanisettesRepository
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SearchSanisettesUseCaseTest {

    private lateinit var repository: SanisettesRepository
    private lateinit var useCase: SearchSanisettesUseCase

    @Before
    fun setup() {
        repository = mockk()
        useCase = SearchSanisettesUseCase(repository)
    }

    @Test
    fun `invoke returns expected Sanisettes when repository returns success`() = runTest {
        // Given
        val location = mockk<Location> {
            every { latitude } returns 48.8566
            every { longitude } returns 2.3522
        }
        val expected = mockk<Sanisettes>()
        coEvery { repository.searchSanisettes(location) } returns expected

        // When
        val result = useCase.invoke(location)

        // Then
        assertTrue(result.isSuccess)
        assertEquals(expected, result.getOrNull())
        coVerify { repository.searchSanisettes(location) }
    }

    @Test
    fun `invoke returns failure when repository throws exception`() = runTest {
        // Given
        val location = mockk<Location> {
            every { latitude } returns 48.8566
            every { longitude } returns 2.3522
        }
        val exception = RuntimeException("error")
        coEvery { repository.searchSanisettes(any()) } throws exception

        // When
        val result = useCase.invoke(location)

        // Then
        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
    }
}
