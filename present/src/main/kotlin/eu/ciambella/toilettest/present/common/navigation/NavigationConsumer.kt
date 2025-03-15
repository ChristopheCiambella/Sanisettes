package eu.ciambella.toilettest.present.common.navigation

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import eu.ciambella.toilettest.present.screen.list.navigateToToiletList
import eu.ciambella.toilettest.present.screen.maps.navigateToToiletMaps

class NavigationConsumer(
    private val context: Context
) {

    fun handle(
        navHostController: NavHostController,
        navigationElement: NavigationElement
    ) {
        when (navigationElement) {
            NavigationElement.ToiletList -> navHostController.navigateToToiletList()
            NavigationElement.ToiletMaps -> navHostController.navigateToToiletMaps()
            is NavigationElement.ToiletNavigation -> startNavigationActivity(
                address = navigationElement.address
            )
        }
    }

    private fun startNavigationActivity(address: String) {
        val uri = Uri.parse("google.navigation:q=" + Uri.encode(address))
        val intent = Intent(Intent.ACTION_VIEW, uri).apply {
            setPackage("com.google.android.apps.maps")
            flags = FLAG_ACTIVITY_NEW_TASK
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }

}
