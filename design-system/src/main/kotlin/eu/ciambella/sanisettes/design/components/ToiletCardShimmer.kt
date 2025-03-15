package eu.ciambella.sanisettes.design.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.ciambella.sanisettes.design.atoms.shimmer.Shimmer

@Composable
fun SanisetteCardShimmer() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Shimmer(
                    modifier = Modifier
                        .padding(
                            bottom = 8.dp
                        )
                        .fillMaxWidth()
                        .height(20.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column {
                        SanisetteInfoShimmer()
                        Spacer(Modifier.height(8.dp))
                        SanisetteInfoShimmer()
                    }
                    Spacer(Modifier.weight(1F))
                    Shimmer(
                        modifier = Modifier
                            .padding(
                                start = 24.dp
                            )
                            .size(48.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun SanisetteInfoShimmer() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Shimmer(
            modifier = Modifier.size(24.dp)
        )
        Shimmer(
            modifier = Modifier
                .padding(
                    start = 8.dp
                )
                .width(100.dp)
                .height(20.dp)
        )
    }
}


@Preview
@Composable
fun SanisetteCardShimmerPreview() {
    SanisetteCardShimmer()
}
