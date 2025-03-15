package eu.ciambella.toilettest.design.atoms.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.shimmerEffect(): Modifier = composed {
    background(
        brush = ShimmerBrush()
    )
}
