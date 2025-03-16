package eu.ciambella.sanisettes.design.core.topbar

import androidx.compose.runtime.Composable

@Composable
fun AppTopAppBar(
    property: TopAppBarProperty,
) {
    when (property) {
        is TopAppBarProperty.Default -> TopAppBarDefault(property)
    }
}
