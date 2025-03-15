package eu.ciambella.design.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.ciambella.design.toilettest.content.ContentProperty
import eu.ciambella.design.toilettest.content.LazyColumnContentProperty

@Composable
fun IciContent(
    property: ContentProperty,
    modifier: Modifier = Modifier,
) {
    when (property) {
        is LazyColumnContentProperty -> LazyColumnContent(property, modifier)
    }
}
