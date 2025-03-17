package eu.ciambella.sanisettes.present.common.navigation

import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette

sealed class NavigationElement {
    data object Up : NavigationElement()
    data object SanisetteList : NavigationElement()
    data class Details(
        val sanisette: Sanisette
    ) : NavigationElement()
    data object SanisetteMaps : NavigationElement()
    data class Navigation(
        val address: String,
    ) : NavigationElement()
}
