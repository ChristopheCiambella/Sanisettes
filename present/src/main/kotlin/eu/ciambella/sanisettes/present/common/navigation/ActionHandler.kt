package eu.ciambella.sanisettes.present.common.navigation

class ActionHandler(
    private val navigator: MainNavigator,
) {
    fun handle(action: Action) {
        when (action) {
            is Action.Navigation -> {
                navigator.navigateTo(action.navigationElement)
            }

            is Action.None -> Unit
        }
    }
}
