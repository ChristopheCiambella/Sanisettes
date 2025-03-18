package eu.ciambella.sanisettes.present.common.navigation

import android.content.Context
import androidx.navigation.NavHostController
import eu.ciambella.sanisettes.present.screen.details.navigateToDetails
import eu.ciambella.sanisettes.present.screen.list.navigateToList
import eu.ciambella.sanisettes.present.screen.maps.navigateToMaps
import eu.ciambella.sanisettes.present.utils.ExternalIntentUtils

class NavigationConsumer(
    private val context: Context,
) {

    fun handle(
        navHostController: NavHostController,
        navigationElement: NavigationElement,
    ) {
        when (navigationElement) {
            NavigationElement.Up -> navHostController.popBackStack()

            NavigationElement.SanisetteList -> navHostController.navigateToList()

            NavigationElement.SanisetteMaps -> navHostController.navigateToMaps()

            is NavigationElement.Details -> navHostController.navigateToDetails(
                navigationElement.sanisette
            )

            is NavigationElement.Navigation -> ExternalIntentUtils.startNavigationActivity(
                context = context,
                address = navigationElement.address
            )
        }
    }
}
