package eu.ciambella.sanisettes.present.screen.list

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SANISETTE_LIST_ROUTE = "sanisetteList"

fun NavController.navigateToSanisetteList() {
    navigate(SANISETTE_LIST_ROUTE)
}

fun NavGraphBuilder.sanisetteListScreen() {
    composable(route = SANISETTE_LIST_ROUTE) {
        SanisetteListRoute()
    }
}
