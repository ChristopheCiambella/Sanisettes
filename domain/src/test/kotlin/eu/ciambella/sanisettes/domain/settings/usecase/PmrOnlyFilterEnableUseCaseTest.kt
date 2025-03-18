package eu.ciambella.sanisettes.domain.settings.usecase

import eu.ciambella.sanisettes.domain.settings.SettingsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PmrOnlyFilterEnableUseCaseTest {

    @MockK
    private lateinit var settingsRepository: SettingsRepository

    private lateinit var cut: PmrOnlyFilterEnableUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        cut = PmrOnlyFilterEnableUseCase(settingsRepository)
    }

    @Test
    fun `invoke should return expected flow value`() = runTest {
        // Given
        val expectedValue = true
        coEvery { settingsRepository.pmrFilterEnableFlow() } returns flowOf(expectedValue)

        // When
        val result = cut.invoke().first()

        // Then
        coVerify { settingsRepository.pmrFilterEnableFlow() }
        assertEquals(expectedValue, result)
    }
}
