package eu.ciambella.toilettest.present.common.navigation

sealed interface Action {

    data class Navigation(
        val navigationElement: NavigationElement,
    ) : Action

    data object None : Action

}
