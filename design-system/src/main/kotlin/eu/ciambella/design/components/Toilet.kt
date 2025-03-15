package eu.ciambella.design.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import eu.ciambella.design.toilettest.components.ToiletProperty

@Composable
fun Toilet(
    property: ToiletProperty
) {
    Row {
        Text(text = property.address)
    }
}

@Preview
@Composable
fun ToiletPreview() {
    Toilet(
        property = ToiletProperty(
            address = "104 avenue de paris"
        )
    )
}
