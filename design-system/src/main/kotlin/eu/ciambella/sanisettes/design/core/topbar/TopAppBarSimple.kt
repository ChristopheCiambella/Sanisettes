package eu.ciambella.sanisettes.design.core.topbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSimple(
    property: TopAppBarProperty.SimpleAppBar,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = property.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    )
}
