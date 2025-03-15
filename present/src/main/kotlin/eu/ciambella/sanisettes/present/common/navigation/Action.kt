package eu.ciambella.sanisettes.present.common.navigation

sealed interface Action {

    data class Navigation(
        val navigationElement: NavigationElement,
    ) : Action

    data object None : Action

}
