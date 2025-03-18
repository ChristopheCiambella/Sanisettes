package eu.ciambella.sanisettes.present.screen.list

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val LIST_ROUTE = "list"

fun NavController.navigateToList() {
    navigate(LIST_ROUTE)
}

fun NavGraphBuilder.listScreen() {
    composable(route = LIST_ROUTE) {
        ListRoute()
    }
}
