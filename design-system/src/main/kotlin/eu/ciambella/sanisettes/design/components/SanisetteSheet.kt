package eu.ciambella.sanisettes.design.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import eu.ciambella.sanisettes.design.atoms.button.SimpleButton

@Composable
fun SanisetteSheet(
    property: SanisetteSheetProperty,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(
            vertical = 16.dp
        ),
    ) {
        SanisetteCard(
            property = property.sanisetteProperty
        )
        SimpleButton(
            property = property.simpleButtonProperty
        )
    }
}
