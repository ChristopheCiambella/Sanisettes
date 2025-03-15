package eu.ciambella.toilettest.present.common.navigation

sealed class NavigationElement {
    data object ToiletList : NavigationElement()
    data object ToiletMaps : NavigationElement()
    data class ToiletNavigation(
        val address: String
    ) : NavigationElement()
    data object AppSettings : NavigationElement()
}
