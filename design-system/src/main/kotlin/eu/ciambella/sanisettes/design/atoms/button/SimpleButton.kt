package eu.ciambella.sanisettes.design.atoms.button

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import eu.ciambella.sanisettes.design.atoms.SimpleButtonProperty

@Composable
fun SimpleButton(
    property: SimpleButtonProperty,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = property.onClick,
        modifier = modifier,
    ) {
        Text(stringResource(property.labelResId))
    }
}
