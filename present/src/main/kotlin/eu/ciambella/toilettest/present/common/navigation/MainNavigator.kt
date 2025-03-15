package eu.ciambella.toilettest.present.common.navigation

import eu.ciambella.toilettest.present.utils.SingleEvent
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

    fun navigateToToiletList() {
        navigateTo(NavigationElement.ToiletList)
    }

    fun navigateToToiletMaps() {
        navigateTo(NavigationElement.ToiletMaps)
    }

    fun navigateTo(navigationElement: NavigationElement) {
        navigationFlow.update {
            SingleEvent(navigationElement)
        }
    }

}
