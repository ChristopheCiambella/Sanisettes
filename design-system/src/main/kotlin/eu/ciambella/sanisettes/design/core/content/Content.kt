package eu.ciambella.sanisettes.design.core.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Content(
    property: ContentProperty,
    modifier: Modifier = Modifier,
) {
    when (property) {
        is LazyColumnContentProperty -> LazyColumnContent(property, modifier)
        is MapsContentProperty -> MapsContent(property, modifier)
        is ErrorContentProperty -> ErrorContent(property.property, modifier)
    }
}
