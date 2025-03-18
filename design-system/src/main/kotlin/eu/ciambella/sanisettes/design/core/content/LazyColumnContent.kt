package eu.ciambella.sanisettes.design.core.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.ciambella.sanisettes.design.atoms.SimpleButtonProperty
import eu.ciambella.sanisettes.design.atoms.button.SimpleButton
import eu.ciambella.sanisettes.design.components.Loading
import eu.ciambella.sanisettes.design.components.LoadingProperty
import eu.ciambella.sanisettes.design.components.SanisetteCard
import eu.ciambella.sanisettes.design.components.SanisetteCardProperty
import eu.ciambella.sanisettes.design.components.SanisetteCardShimmer
import eu.ciambella.sanisettes.design.components.SanisetteCardShimmerProperty

@Composable
fun LazyColumnContent(
    property: LazyColumnContentProperty,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()
    LazyColumn(
        userScrollEnabled = property.scrollEnabled,
        state = listState,
        modifier = modifier,
    ) {
        items(items = property.items) { item ->
            when (item) {
                is SimpleButtonProperty -> Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier.fillMaxWidth(),
                ) {
                    SimpleButton(item)
                }
                is LoadingProperty -> Loading(item)
                is SanisetteCardProperty -> SanisetteCard(item)
                is SanisetteCardShimmerProperty -> SanisetteCardShimmer()
            }
        }
    }
}
