package eu.ciambella.sanisettes.design.atoms.shimmer

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private const val WIDTH_SHADOW = 500f
private const val TRANSITION_DURATION_IN_MILLIS = 1000
private const val ANGLE_OF_AXIS_Y = 270f

@Composable
fun ShimmerBrush(): Brush {
    val gradient = listOf(
        Color.Gray,
        Color.LightGray,
        Color.DarkGray,
    )
    val infiniteTransition = rememberInfiniteTransition(label = "shimmer transition")
    val translateAnimation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = TRANSITION_DURATION_IN_MILLIS + WIDTH_SHADOW,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = TRANSITION_DURATION_IN_MILLIS),
        ),
        label = "shimmer offset"
    )
    return Brush.linearGradient(
        colors = gradient,
        start = Offset(
            x = translateAnimation.value - WIDTH_SHADOW,
            y = 0.0f
        ),
        end = Offset(
            x = translateAnimation.value,
            y = ANGLE_OF_AXIS_Y
        ),
    )
}
