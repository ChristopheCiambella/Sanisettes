package eu.ciambella.toilettest.present.screen.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.ciambella.design.toilettest.scaffold.ScaffoldProperty
import eu.ciambella.toilettest.domain.toilet.usecase.GetSanisettesUseCase
import eu.ciambella.toilettest.domain.utils.CoroutineDispatcherProvider
import eu.ciambella.toilettest.present.common.navigation.Action
import eu.ciambella.toilettest.present.common.navigation.ActionHandler
import eu.ciambella.toilettest.present.common.navigation.EventActionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ToiletMapsViewModel(
    private val listScreenMapper: ToiletMapsScreenMapper,
    private val getToiletUseCase: GetSanisettesUseCase,
    private val dispatcherProvider: CoroutineDispatcherProvider,
    private val actionHandler: ActionHandler,
) : ViewModel(), EventActionHandler {

    private val model = MutableStateFlow(
        ToiletMapsState()
    )

    val state: StateFlow<ScaffoldProperty> = model.map {
        mapToUI(it)
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        listScreenMapper.loading(this)
    )

    private fun mapToUI(
        state: ToiletMapsState,
    ): ScaffoldProperty = listScreenMapper.map(
        eventActionHandler = this,
        state = state,
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

    override fun handle(action: Action) {
        actionHandler.handle(action)
    }

}
