package eu.ciambella.toilettest.present.screen.maps

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val TOILET_MAPS_ROUTE = "toiletMaps"

fun NavController.navigateToToiletMaps() {
    navigate(TOILET_MAPS_ROUTE)
}

fun NavGraphBuilder.toiletMapsScreen() {
    composable(route = TOILET_MAPS_ROUTE) {
        ToiletMapsRoute()
    }
}
