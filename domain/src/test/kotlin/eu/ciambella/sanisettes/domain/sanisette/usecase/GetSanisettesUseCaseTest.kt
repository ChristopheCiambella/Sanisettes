package eu.ciambella.sanisettes.domain.sanisette.usecase

import eu.ciambella.sanisettes.domain.sanisette.SanisettesRepository
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetSanisettesUseCaseTest {

    @MockK
    private lateinit var sanisettesRepository: SanisettesRepository
    private lateinit var cut: GetSanisettesUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        cut = GetSanisettesUseCase(sanisettesRepository)
    }

    @Test
    fun `invoke with default offset returns expected Sanisettes`() = runTest {
        // Given
        val expected = mockk<Sanisettes>()
        coEvery { sanisettesRepository.getSanisettes(0) } returns expected

        // When
        val result = cut.invoke()

        // Then
        assertTrue(result.isSuccess)
        assertEquals(expected, result.getOrNull())
        coVerify { sanisettesRepository.getSanisettes(0) }
    }

    @Test
    fun `invoke with explicit offset returns expected Sanisettes`() = runTest {
        // Given
        val offset = 10
        val expected = mockk<Sanisettes>()
        coEvery { sanisettesRepository.getSanisettes(offset) } returns expected

        // When
        val result = cut.invoke(offset)

        // Then
        assertTrue(result.isSuccess)
        assertEquals(expected, result.getOrNull())
        coVerify { sanisettesRepository.getSanisettes(offset) }
    }

    @Test
    fun `invoke returns failure when repository throws exception`() = runTest {
        // Given
        val exception = RuntimeException("error")
        coEvery { sanisettesRepository.getSanisettes(any()) } throws exception

        // When
        val result = cut.invoke()

        // Then
        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
    }
}
