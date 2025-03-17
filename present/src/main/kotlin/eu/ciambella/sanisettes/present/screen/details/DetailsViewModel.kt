package eu.ciambella.sanisettes.present.screen.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.ciambella.sanisettes.design.core.scaffold.ScaffoldProperty
import eu.ciambella.sanisettes.present.common.navigation.Action
import eu.ciambella.sanisettes.present.common.navigation.ActionHandler
import eu.ciambella.sanisettes.present.common.navigation.EventActionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val detailsScreenMapper: DetailsScreenMapper,
    private val actionHandler: ActionHandler,
) : ViewModel(), EventActionHandler {

    private val arguments = DetailsArgs(savedStateHandle)

    private val model = MutableStateFlow(
        DetailsState(
            sanisette = arguments.sanisette
        )
    )

    val state: StateFlow<ScaffoldProperty> = model.map {
        mapToUI(it)
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        detailsScreenMapper.loading(this)
    )

    private fun mapToUI(
        state: DetailsState
    ): ScaffoldProperty = detailsScreenMapper.map(
        state = state,
        eventActionHandler = this,
    )

    override fun handle(action: Action) {
        actionHandler.handle(action)
    }
}
