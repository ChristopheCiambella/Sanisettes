package eu.ciambella.design.content

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.ciambella.design.components.Toilet
import eu.ciambella.design.toilettest.components.ToiletProperty
import eu.ciambella.design.toilettest.content.LazyColumnContentProperty

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
                is ToiletProperty -> Toilet(item)
            }
        }
    }
}
