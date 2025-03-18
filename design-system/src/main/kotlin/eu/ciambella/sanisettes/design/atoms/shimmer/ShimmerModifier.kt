package eu.ciambella.sanisettes.design.atoms.shimmer

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.shimmerEffect(): Modifier = composed {
    background(
        brush = ShimmerBrush()
    )
}
