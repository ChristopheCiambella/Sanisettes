package eu.ciambella.sanisettes.present.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import eu.ciambella.sanisettes.present.common.navigation.MainNavigator
import eu.ciambella.sanisettes.present.common.navigation.NavigationConsumer
import eu.ciambella.sanisettes.present.screen.details.detailsScreen
import eu.ciambella.sanisettes.present.screen.list.sanisetteListScreen
import eu.ciambella.sanisettes.present.screen.maps.sanisetteMapsScreen
import org.koin.compose.koinInject

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
) {
    val mainNavigator: MainNavigator = koinInject<MainNavigator>()
    val navigationConsumer: NavigationConsumer = koinInject<NavigationConsumer>()
    LaunchedEffect("navigation") {
        mainNavigator.navigationEvents().collect { navigationElement ->
            navigationConsumer.handle(
                navHostController = navHostController,
                navigationElement = navigationElement,
            )
        }
    }
    CompositionLocalProvider {
        NavHost(
            navController = navHostController,
            startDestination = startDestination,
            modifier = modifier
        ) {
            sanisetteListScreen()
            detailsScreen()
            sanisetteMapsScreen()
        }
    }
}
