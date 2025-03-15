package eu.ciambella.toilettest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import eu.ciambella.toilettest.present.screen.list.toiletListScreen

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
) {
    CompositionLocalProvider {
        NavHost(
            navController = navHostController,
            startDestination = startDestination,
            modifier = modifier
        ) {
            toiletListScreen()
        }
    }
}
