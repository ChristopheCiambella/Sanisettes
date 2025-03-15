package eu.ciambella.sanisettes.present.screen.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.ciambella.sanisettes.design.core.scaffold.ScaffoldProperty
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.domain.sanisette.usecase.GetSanisettesUseCase
import eu.ciambella.sanisettes.domain.utils.CoroutineDispatcherProvider
import eu.ciambella.sanisettes.present.common.navigation.Action
import eu.ciambella.sanisettes.present.common.navigation.ActionHandler
import eu.ciambella.sanisettes.present.common.navigation.EventActionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SanisetteMapsViewModel(
    private val listScreenMapper: SanisetteMapsScreenMapper,
    private val getToiletUseCase: GetSanisettesUseCase,
    private val dispatcherProvider: CoroutineDispatcherProvider,
    private val actionHandler: ActionHandler,
) : ViewModel(), EventActionHandler {

    private val model = MutableStateFlow(
        SanisetteMapsState()
    )

    val state: StateFlow<ScaffoldProperty> = model.map {
        mapToUI(it)
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        listScreenMapper.loading(this)
    )

    private fun mapToUI(
        state: SanisetteMapsState,
    ): ScaffoldProperty = listScreenMapper.map(
        eventActionHandler = this,
        state = state,
        onSanisetteClicked = ::onSanisetteClicked,
        onBottomSheetDismiss = ::onBottomSheetDismiss
    )

    fun create() {
        viewModelScope.launch(dispatcherProvider.io) {
            model.update {
                it.copy(
                    sanisettes = getToiletUseCase.invoke()
                )
            }
        }
    }

    private fun onSanisetteClicked(sanisette: Sanisette) {
        model.update {
            it.copy(
                sanisetteDetails = sanisette
            )
        }
    }

    private fun onBottomSheetDismiss() {
        model.update {
            it.copy(
                sanisetteDetails = null
            )
        }
    }

    override fun handle(action: Action) {
        actionHandler.handle(action)
    }
}
