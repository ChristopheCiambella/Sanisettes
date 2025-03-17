package eu.ciambella.sanisettes.present.screen.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.ciambella.sanisettes.design.core.scaffold.ScaffoldProperty
import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.domain.sanisette.usecase.GetSanisettesUseCase
import eu.ciambella.sanisettes.domain.sanisette.usecase.SearchSanisettesUseCase
import eu.ciambella.sanisettes.domain.sanisette.usecase.ShouldFetchNewLocationDataUseCase
import eu.ciambella.sanisettes.domain.settings.usecase.ChangeOnlyFilterEnableUseCase
import eu.ciambella.sanisettes.domain.settings.usecase.PmrOnlyFilterEnableUseCase
import eu.ciambella.sanisettes.domain.utils.CoroutineDispatcherProvider
import eu.ciambella.sanisettes.present.common.navigation.Action
import eu.ciambella.sanisettes.present.common.navigation.ActionHandler
import eu.ciambella.sanisettes.present.common.navigation.EventActionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SanisetteMapsViewModel(
    private val usesCases: UseCases,
    private val sanisetteMapsScreenMapper: SanisetteMapsScreenMapper,
    private val dispatcherProvider: CoroutineDispatcherProvider,
    private val actionHandler: ActionHandler,
) : ViewModel(), EventActionHandler {

    class UseCases(
        val getSanisettesUseCase: GetSanisettesUseCase,
        val searchSanisettesUseCase: SearchSanisettesUseCase,
        val shouldFetchNewLocationDataUseCase: ShouldFetchNewLocationDataUseCase,
        val pmrOnlyFilterEnableUseCase: PmrOnlyFilterEnableUseCase,
        val changeOnlyFilterEnableUseCase: ChangeOnlyFilterEnableUseCase,
    )

    private val model = MutableStateFlow(
        SanisetteMapsState()
    )

    private var loadingJob: Job? = null

    val state: StateFlow<ScaffoldProperty> = model.map {
        mapToUI(it)
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        sanisetteMapsScreenMapper.loading(this)
    )

    private fun mapToUI(
        state: SanisetteMapsState,
    ): ScaffoldProperty = sanisetteMapsScreenMapper.map(
        eventActionHandler = this,
        state = state,
        onSanisetteClicked = ::onSanisetteClicked,
        onBottomSheetDismiss = ::onBottomSheetDismiss,
        onLocationChanged = ::requestSearchSanisetteOnPosition,
        onPmrFilterValueChange = ::onPmrFilterValueChange
    )

    fun create() {
        viewModelScope.launch(dispatcherProvider.io) {
            val result = usesCases.getSanisettesUseCase.invoke()
            model.update {
                it.copy(
                    firstSanisettesResult = result,
                    sanisettes = result.getOrNull()?.sanisettes ?: emptyList(),
                    searchLocation = null,
                )
            }
        }
        listenPmrFilterChange()
    }

    private fun listenPmrFilterChange() {
        viewModelScope.launch(dispatcherProvider.io) {
            usesCases.pmrOnlyFilterEnableUseCase.invoke().collect { enabled ->
                model.update {
                    it.copy(
                        pmrFilterEnable = enabled,
                    )
                }
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

    private fun requestSearchSanisetteOnPosition(location: Location) {
        val needRequest = usesCases.shouldFetchNewLocationDataUseCase.invoke(
            previousLocation = model.value.searchLocation,
            newLocation = location
        )
        if (!needRequest) {
            return
        }
        loadingJob?.cancel()
        loadingJob = viewModelScope.launch(dispatcherProvider.io) {
            val result = usesCases.searchSanisettesUseCase.invoke(location)
            model.update {
                it.copy(
                    searchSanisettesResult = result,
                    sanisettes = result.getOrNull()?.sanisettes ?: it.sanisettes,
                    searchLocation = location
                )
            }
        }
    }

    private fun onPmrFilterValueChange(newValue: Boolean) {
        viewModelScope.launch(dispatcherProvider.io) {
            usesCases.changeOnlyFilterEnableUseCase.invoke(newValue)
        }
    }

    override fun handle(action: Action) {
        actionHandler.handle(action)
    }
}
