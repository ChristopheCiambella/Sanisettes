package eu.ciambella.sanisettes.present.screen.maps

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val MAPS_ROUTE = "maps"

fun NavController.navigateToMaps() {
    navigate(MAPS_ROUTE)
}

fun NavGraphBuilder.mapsScreen() {
    composable(route = MAPS_ROUTE) {
        MapsRoute()
    }
}
