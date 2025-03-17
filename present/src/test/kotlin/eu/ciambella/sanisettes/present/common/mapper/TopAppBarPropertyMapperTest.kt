package eu.ciambella.sanisettes.present.common.mapper

import android.content.Context
import eu.ciambella.sanisettes.design.core.topbar.TopAppBarProperty
import eu.ciambella.sanisettes.present.R
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test

class TopAppBarPropertyMapperTest {

    @MockK
    private lateinit var context: Context

    private lateinit var cut: TopAppBarPropertyMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        cut = TopAppBarPropertyMapper(context)
    }

    @Test
    fun `mapSimpleTopAppBar returns SimpleAppBar with correct title`() {
        // Given
        every { context.getString(R.string.app_name) } returns "My App Name"

        // When
        val result = cut.mapSimpleTopAppBar()

        // Then
        if (result is TopAppBarProperty.SimpleAppBar) {
            assertEquals("My App Name", result.title)
        } else {
            fail("Expected a SimpleAppBar")
        }
    }

    @Test
    fun `mapPmrFilterTopAppBar returns SwitchFilterAppBar with correct fields`() {
        // Given
        every { context.getString(R.string.app_name) } returns "My App Name"
        every { context.getString(R.string.pmr) } returns "PMR Filter"

        // When
        val result = cut.mapPmrFilterTopAppBar(true) {}

        // Then
        if (result is TopAppBarProperty.SwitchFilterAppBar) {
            assertEquals("My App Name", result.title)
            assertEquals("PMR Filter", result.switchLabel)
            assertTrue(result.switchFilterOn)
        } else {
            fail("Expected a SwitchFilterAppBar")
        }
    }
}
