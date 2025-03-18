package eu.ciambella.sanisettes.present.common.navigation

import eu.ciambella.sanisettes.present.utils.SingleEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.update

class MainNavigator {

    private val navigationFlow = MutableStateFlow<SingleEvent<NavigationElement>?>(null)

    fun navigationEvents(): Flow<NavigationElement> = navigationFlow
        .filterNotNull()
        .mapNotNull {
            it.getContentIfNotHandled()
        }

    fun navigateTo(navigationElement: NavigationElement) {
        navigationFlow.update {
            SingleEvent(navigationElement)
        }
    }
}
