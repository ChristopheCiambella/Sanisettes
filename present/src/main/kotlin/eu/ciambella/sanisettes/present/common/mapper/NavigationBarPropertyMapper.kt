package eu.ciambella.sanisettes.present.common.mapper

import eu.ciambella.sanisettes.design.core.bottombar.NavigationBarItemProperty
import eu.ciambella.sanisettes.design.core.bottombar.NavigationBarProperty
import eu.ciambella.sanisettes.design.R
import eu.ciambella.sanisettes.present.common.navigation.Action
import eu.ciambella.sanisettes.present.common.navigation.EventActionHandler
import eu.ciambella.sanisettes.present.common.navigation.NavigationElement

class NavigationBarPropertyMapper {

    fun main(
        selectedRoute: RouteNavigationBarProperty,
        eventActionHandler: EventActionHandler,
    ): NavigationBarProperty {
        val navigationBarItems = listOf(
            mapSanisetteListNavigationBar(selectedRoute, eventActionHandler),
            mapSanisetteMapsNavigationBar(selectedRoute, eventActionHandler)
        )
        return NavigationBarProperty(navigationBarItems)
    }

    private fun mapSanisetteListNavigationBar(
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
                    navigationElement = NavigationElement.SanisetteList
                )
            )
        }
    )

    private fun mapSanisetteMapsNavigationBar(
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
                    navigationElement = NavigationElement.SanisetteMaps
                )
            )
        }
    )

}
