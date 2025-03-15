package eu.ciambella.toilettest.navigation

import androidx.navigation.NavHostController
import eu.ciambella.toilettest.present.common.navigation.NavigationElement
import eu.ciambella.toilettest.present.screen.list.navigateToToiletList
import eu.ciambella.toilettest.present.screen.maps.navigateToToiletMaps

class NavigationConsumer {
    fun handle(
        navHostController: NavHostController,
        navigationElement: NavigationElement
    ) {
        when (navigationElement) {
            NavigationElement.ToiletList -> navHostController.navigateToToiletList()
            NavigationElement.ToiletMaps -> navHostController.navigateToToiletMaps()
        }
    }

}
