package eu.ciambella.toilettest.present.common.mapper

import eu.ciambella.design.toilettest.bottombar.NavigationBarItemProperty
import eu.ciambella.design.toilettest.bottombar.NavigationBarProperty
import eu.ciambella.toilettest.design.R
import eu.ciambella.toilettest.present.common.navigation.Action
import eu.ciambella.toilettest.present.common.navigation.EventActionHandler
import eu.ciambella.toilettest.present.common.navigation.NavigationElement

class NavigationBarPropertyMapper {

    fun main(
        selectedRoute: RouteNavigationBarProperty,
        eventActionHandler: EventActionHandler,
    ): NavigationBarProperty {
        val navigationBarItems = listOf(
            mapToiletListNavigationBar(selectedRoute, eventActionHandler),
            mapToiletMapsNavigationBar(selectedRoute, eventActionHandler)
        )
        return NavigationBarProperty(navigationBarItems)
    }

    private fun mapToiletListNavigationBar(
        selectedRoute: RouteNavigationBarProperty,
        eventActionHandler: EventActionHandler,
    ) = NavigationBarItemProperty(
        selectedIcon = R.drawable.list_selected,
        unselectedIcon = R.drawable.list_unselected,
        label = "List", // TODO string
        isSelected = selectedRoute == RouteNavigationBarProperty.LIST,
        onClick = {
            eventActionHandler.handle(
                Action.Navigation(
                    navigationElement = NavigationElement.ToiletList
                )
            )
        }
    )

    private fun mapToiletMapsNavigationBar(
        selectedRoute: RouteNavigationBarProperty,
        eventActionHandler: EventActionHandler,
    ) = NavigationBarItemProperty(
        selectedIcon = R.drawable.maps_selected,
        unselectedIcon = R.drawable.maps_unselected,
        label = "Maps", // TODO string
        isSelected = selectedRoute == RouteNavigationBarProperty.MAPS,
        onClick = {
            eventActionHandler.handle(
                Action.Navigation(
                    navigationElement = NavigationElement.ToiletMaps
                )
            )
        }
    )

}
