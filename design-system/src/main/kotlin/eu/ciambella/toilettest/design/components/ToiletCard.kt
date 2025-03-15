package eu.ciambella.toilettest.design.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.WheelchairPickup
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.ciambella.design.toilettest.components.SanisetteCardProperty

@Composable
fun SanisetteCard(
    property: SanisetteCardProperty,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = property.onClick),
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
                Text(
                    text = property.address,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(
                        bottom = 8.dp
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccessTime,
                                contentDescription = "Heure d'ouverture",
                                modifier = Modifier.size(24.dp)
                            )
                            Text(
                                text = property.openingHours,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(
                                    start = 8.dp
                                )
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(
                                top = 8.dp
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Default.Navigation,
                                contentDescription = "Distance",
                                modifier = Modifier.size(24.dp)
                            )
                            Text(
                                text = property.distance,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(
                                    start = 8.dp
                                )
                            )
                        }
                    }
                    Spacer(Modifier.weight(1F))
                    Icon(
                        imageVector = Icons.Default.WheelchairPickup,
                        contentDescription = "Accessible PMR",
                        tint = if (property.isPmr) Color.Green else Color.Red,
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

@Preview
@Composable
fun ToiletPreview() {
    SanisetteCard(
        property = SanisetteCardProperty(
            address = "104 avenue de paris",
            openingHours = "6 h - 1 h",
            distance = "360m",
            isPmr = true,
            onClick = {}
        )
    )
}
