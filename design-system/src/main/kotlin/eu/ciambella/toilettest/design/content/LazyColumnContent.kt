package eu.ciambella.toilettest.design.content

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.ciambella.toilettest.design.components.SanisetteCard
import eu.ciambella.design.toilettest.components.SanisetteCardProperty
import eu.ciambella.design.toilettest.components.SanisetteCardShimmerProperty
import eu.ciambella.design.toilettest.content.LazyColumnContentProperty
import eu.ciambella.toilettest.design.components.SanisetteCardShimmer

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
