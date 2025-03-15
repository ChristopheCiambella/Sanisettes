package eu.ciambella.sanisettes.design.atoms.button

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import eu.ciambella.sanisettes.design.atoms.SimpleButtonProperty

@Composable
fun SimpleButton(
    property: SimpleButtonProperty,
) {
    Button(
        onClick = property.onClick
    ) {
        Text(property.label)
    }
}

@Preview
@Composable
fun SimpleButtonPreview() {
    SimpleButton(
        SimpleButtonProperty(
            label = "Test",
            onClick = {}
        )
    )
}
