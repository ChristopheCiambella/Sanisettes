package eu.ciambella.sanisettes.present.common.mapper

import android.content.Context
import eu.ciambella.sanisettes.present.R
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ErrorPropertyMapperTest {

    @MockK
    private lateinit var context: Context

    private lateinit var cut: ErrorPropertyMapper

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        cut = ErrorPropertyMapper(context)
    }

    @Test
    fun `mapUnknownError returns correct ErrorProperty`() {
        // Given
        val expectedTitle = "Error Title"
        val expectedMessage = "Error Message"
        every { context.getString(R.string.error_title) } returns expectedTitle
        every { context.getString(R.string.error_message) } returns expectedMessage

        // When
        val errorProperty = cut.mapUnknownError()

        // Then
        assertEquals(expectedTitle, errorProperty.title)
        assertEquals(expectedMessage, errorProperty.message)
    }
}
