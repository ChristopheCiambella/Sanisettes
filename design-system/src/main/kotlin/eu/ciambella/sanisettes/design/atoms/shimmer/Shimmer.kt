package eu.ciambella.sanisettes.design.atoms.shimmer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Shimmer(
    modifier: Modifier = Modifier,
    roundedCornerShapeSize: Dp = 4.dp
) = Spacer(
    modifier
        .clip(RoundedCornerShape(roundedCornerShapeSize))
        .shimmerEffect()
)

@Composable
@Preview
fun ShimmerPreview() {
    Shimmer()
}
