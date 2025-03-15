package eu.ciambella.toilettest.present.common.mapper

import eu.ciambella.design.toilettest.bottombar.NavigationBarItemProperty
import eu.ciambella.design.toilettest.bottombar.NavigationBarProperty
import eu.ciambella.toilettest.design.R

class NavigationBarPropertyMapper {

    fun main(
        selectedRoute: RouteNavigationBarProperty,
    ): NavigationBarProperty {
        val navigationBarItems = listOf(
            mapToiletListNavigationBar(selectedRoute),
            mapToiletMapsNavigationBar(selectedRoute)
        )
        return NavigationBarProperty(navigationBarItems)
    }

    private fun mapToiletListNavigationBar(
        selectedRoute: RouteNavigationBarProperty
    ) = NavigationBarItemProperty(
        selectedIcon = R.drawable.list_selected,
        unselectedIcon = R.drawable.list_unselected,
        label = "List",
        isSelected = selectedRoute == RouteNavigationBarProperty.LIST,
        onClick = {

        }
    )

    private fun mapToiletMapsNavigationBar(
        selectedRoute: RouteNavigationBarProperty
    ) = NavigationBarItemProperty(
        selectedIcon = R.drawable.maps_selected,
        unselectedIcon = R.drawable.maps_unselected,
        label = "Maps",
        isSelected = selectedRoute == RouteNavigationBarProperty.MAPS,
        onClick = {

        }
    )

}
