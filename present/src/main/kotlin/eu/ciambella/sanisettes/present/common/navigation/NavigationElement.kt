package eu.ciambella.sanisettes.present.common.navigation

sealed class NavigationElement {
    data object SanisetteList : NavigationElement()
    data object SanisetteMaps : NavigationElement()
    data class SanisetteNavigation(
        val address: String,
    ) : NavigationElement()
}
