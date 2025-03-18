package eu.ciambella.sanisettes.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val darkColorScheme = darkColorScheme(
    primary = Color(0xFF6C8DD2),
    onPrimary = Color.White,
    secondary = Color(0xFF303030),
    onSecondary = Color.White,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF1F1F1F),
    onSurface = Color.White,
    error = Color(0xFFCF6679),
    onError = Color.Black
)

val lightColorScheme = lightColorScheme(
    primary = Color(0xFF003893),
    onPrimary = Color.White,
    secondary = Color(0xFFF5F5F5),
    onSecondary = Color.Black,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color(0xFFE3000F),
    onError = Color.White
)

@Composable
fun MainTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
