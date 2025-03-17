package eu.ciambella.sanisettes.present.screen.details

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.net.URLEncoder

private const val SANISETTE_ARG = "sanisette"

const val DETAILS_ROUTE_BASE = "details"
const val DETAILS_ROUTE = "$DETAILS_ROUTE_BASE/{$SANISETTE_ARG}"

internal class DetailsArgs(
    val sanisette: Sanisette,
) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        sanisette = Json.decodeFromString(
            URLDecoder.decode(
                checkNotNull(savedStateHandle[SANISETTE_ARG]),
                "UTF-8"
            )
        )
    )
}

fun NavController.navigateToDetails(sanisette: Sanisette) {
    val encodedSanisette = URLEncoder.encode(Json.encodeToString(sanisette), "UTF-8")
    navigate("$DETAILS_ROUTE_BASE/$encodedSanisette")
}

fun NavGraphBuilder.detailsScreen() {
    composable(
        route = DETAILS_ROUTE,
        arguments = listOf(
            navArgument(SANISETTE_ARG) {
                type = NavType.StringType
            }
        )
    ) {
        SanisetteDetailsRoute()
    }
}
