package eu.ciambella.toilettest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import eu.ciambella.toilettest.present.common.navigation.MainNavigator
import eu.ciambella.toilettest.present.screen.list.toiletListScreen
import eu.ciambella.toilettest.present.screen.maps.toiletMapsScreen
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
            toiletListScreen()
            toiletMapsScreen()
        }
    }
}
