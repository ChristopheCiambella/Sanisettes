package eu.ciambella.sanisettes.present.screen.maps

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SANISETTE_MAPS_ROUTE = "sanisettesMaps"

fun NavController.navigateToSanisetteMaps() {
    navigate(SANISETTE_MAPS_ROUTE)
}

fun NavGraphBuilder.sanisetteMapsScreen() {
    composable(route = SANISETTE_MAPS_ROUTE) {
        SanisetteMapsRoute()
    }
}
