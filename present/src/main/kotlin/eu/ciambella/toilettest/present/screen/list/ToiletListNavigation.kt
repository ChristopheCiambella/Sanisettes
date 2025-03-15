package eu.ciambella.toilettest.present.screen.list

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val TOILET_LIST_ROUTE = "toiletList"

fun NavController.navigateToToiletList() {
    navigate(TOILET_LIST_ROUTE)
}

fun NavGraphBuilder.toiletListScreen() {
    composable(route = TOILET_LIST_ROUTE) {
        ToiletListRoute()
    }
}
