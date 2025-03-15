package eu.ciambella.toilettest.present.screen.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.ciambella.design.toilettest.scaffold.ScaffoldProperty
import eu.ciambella.toilettest.domain.location.usecase.HasLocationPermissionUseCase
import eu.ciambella.toilettest.domain.toilet.usecase.GetToiletUseCase
import eu.ciambella.toilettest.domain.utils.CoroutineDispatcherProvider
import eu.ciambella.toilettest.present.common.navigation.Action
import eu.ciambella.toilettest.present.common.navigation.ActionHandler
import eu.ciambella.toilettest.present.common.navigation.EventActionHandler
import eu.ciambella.toilettest.present.common.navigation.NavigationElement
import eu.ciambella.toilettest.present.utils.SingleEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ToiletListViewModel(
    private val listScreenMapper: ToiletListScreenMapper,
    private val getToiletUseCase: GetToiletUseCase,
    private val hasLocationPermissionUseCase: HasLocationPermissionUseCase,
    private val dispatcherProvider: CoroutineDispatcherProvider,
    private val actionHandler: ActionHandler,
) : ViewModel(), EventActionHandler {

    private val model = MutableStateFlow(
        ToiletListState()
    )

    val state: StateFlow<ScaffoldProperty> = model.map {
        mapToUI(it)
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        listScreenMapper.loading(this)
    )

    private fun mapToUI(
        state: ToiletListState
    ): ScaffoldProperty = listScreenMapper.map(
        state = state,
        eventActionHandler = this,
    )

    fun create() {
        viewModelScope.launch(dispatcherProvider.io) {
            model.update {
                it.copy(
                    toilets = getToiletUseCase.invoke()
                )
            }
        }
    }

    fun onLocationPermissionGranted() {
        create()
    }

    fun shouldShowRationaleLocationPermission() {
        handle(
            Action.Navigation(
                NavigationElement.AppSettings
            )
        )
    }

    override fun handle(action: Action) {
        actionHandler.handle(action)
    }

}
