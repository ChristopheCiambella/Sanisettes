package eu.ciambella.sanisettes.present.common.navigation

import android.content.Context
import androidx.navigation.NavHostController
import eu.ciambella.sanisettes.present.screen.list.navigateToSanisetteList
import eu.ciambella.sanisettes.present.screen.maps.navigateToSanisetteMaps
import eu.ciambella.sanisettes.present.utils.ExternalIntentUtils

class NavigationConsumer(
    private val context: Context,
) {

    fun handle(
        navHostController: NavHostController,
        navigationElement: NavigationElement,
    ) {
        when (navigationElement) {
            NavigationElement.SanisetteList -> navHostController.navigateToSanisetteList()
            NavigationElement.SanisetteMaps -> navHostController.navigateToSanisetteMaps()
            is NavigationElement.SanisetteNavigation -> ExternalIntentUtils.startNavigationActivity(
                context = context,
                address = navigationElement.address
            )
        }
    }
}
