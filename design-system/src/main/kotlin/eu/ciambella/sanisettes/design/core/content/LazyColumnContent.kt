package eu.ciambella.sanisettes.design.core.content

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.ciambella.sanisettes.design.components.SanisetteCard
import eu.ciambella.sanisettes.design.components.SanisetteCardProperty
import eu.ciambella.sanisettes.design.components.SanisetteCardShimmer
import eu.ciambella.sanisettes.design.components.SanisetteCardShimmerProperty

@Composable
fun LazyColumnContent(
    property: LazyColumnContentProperty,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        userScrollEnabled = property.scrollEnabled,
        modifier = modifier,
    ) {
        items(items = property.items) { item ->
            when (item) {
                is SanisetteCardProperty -> SanisetteCard(item)
                is SanisetteCardShimmerProperty -> SanisetteCardShimmer()
            }
        }
    }
}
