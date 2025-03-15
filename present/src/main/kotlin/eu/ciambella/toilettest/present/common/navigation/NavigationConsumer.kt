package eu.ciambella.toilettest.present.common.navigation

import android.content.Context
import androidx.navigation.NavHostController
import eu.ciambella.toilettest.present.screen.list.navigateToToiletList
import eu.ciambella.toilettest.present.screen.maps.navigateToToiletMaps
import eu.ciambella.toilettest.present.utils.ExternalIntentUtils

class NavigationConsumer(
    private val context: Context,
) {

    fun handle(
        navHostController: NavHostController,
        navigationElement: NavigationElement,
    ) {
        when (navigationElement) {
            NavigationElement.ToiletList -> navHostController.navigateToToiletList()
            NavigationElement.ToiletMaps -> navHostController.navigateToToiletMaps()
            is NavigationElement.ToiletNavigation -> ExternalIntentUtils.startNavigationActivity(
                context, navigationElement.address
            )
            is NavigationElement.AppSettings -> ExternalIntentUtils.openAppSettings(context)
        }
    }

}
