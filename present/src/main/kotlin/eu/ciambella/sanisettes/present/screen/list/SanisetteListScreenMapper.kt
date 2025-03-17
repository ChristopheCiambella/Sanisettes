package eu.ciambella.sanisettes.present.screen.list

import eu.ciambella.sanisettes.design.components.LoadingProperty
import eu.ciambella.sanisettes.design.components.Property
import eu.ciambella.sanisettes.design.components.SanisetteCardShimmerProperty
import eu.ciambella.sanisettes.design.core.content.ContentProperty
import eu.ciambella.sanisettes.design.core.content.ErrorContentProperty
import eu.ciambella.sanisettes.design.core.content.LazyColumnContentProperty
import eu.ciambella.sanisettes.design.core.scaffold.ScaffoldProperty
import eu.ciambella.sanisettes.design.core.topbar.TopAppBarProperty
import eu.ciambella.sanisettes.domain.logger.LoggerProvider
import eu.ciambella.sanisettes.present.common.mapper.ErrorPropertyMapper
import eu.ciambella.sanisettes.present.common.mapper.NavigationBarPropertyMapper
import eu.ciambella.sanisettes.present.common.mapper.RouteNavigationBarProperty
import eu.ciambella.sanisettes.present.common.mapper.SanisetteCardMapper
import eu.ciambella.sanisettes.present.common.mapper.TopAppBarPropertyMapper
import eu.ciambella.sanisettes.present.common.navigation.Action
import eu.ciambella.sanisettes.present.common.navigation.EventActionHandler
import eu.ciambella.sanisettes.present.common.navigation.NavigationElement

class SanisetteListScreenMapper(
    private val navigationBarPropertyMapper: NavigationBarPropertyMapper,
    private val sanisetteCardMapper: SanisetteCardMapper,
    private val errorPropertyMapper: ErrorPropertyMapper,
    private val topAppBarPropertyMapper: TopAppBarPropertyMapper,
    private val loggerProvider: LoggerProvider,
) {

    companion object {
        private const val TAG = "SanisetteListScreenMapper"
    }

    private fun scaffold(
        contentProperty: ContentProperty,
        topAppBarProperty: TopAppBarProperty,
        eventActionHandler: EventActionHandler,
    ) = ScaffoldProperty(
        topAppBarProperty = topAppBarProperty,
        contentProperty = contentProperty,
        navigationBarProperty = navigationBarPropertyMapper.main(
            selectedRoute = RouteNavigationBarProperty.LIST,
            eventActionHandler = eventActionHandler
        ),
    )

    fun loading(
        eventActionHandler: EventActionHandler,
    ): ScaffoldProperty = scaffold(
        eventActionHandler = eventActionHandler,
        topAppBarProperty = topAppBarPropertyMapper.mapSimpleTopAppBar(),
        contentProperty = LazyColumnContentProperty(
            scrollEnabled = false,
            items = mutableListOf(
                SanisetteCardShimmerProperty,
                SanisetteCardShimmerProperty,
                SanisetteCardShimmerProperty,
                SanisetteCardShimmerProperty,
                SanisetteCardShimmerProperty,
                SanisetteCardShimmerProperty,
                SanisetteCardShimmerProperty,
                SanisetteCardShimmerProperty,
                SanisetteCardShimmerProperty,
                SanisetteCardShimmerProperty,
                SanisetteCardShimmerProperty,
                SanisetteCardShimmerProperty,
            )
        )
    )

    fun map(
        state: SanisetteListState,
        eventActionHandler: EventActionHandler,
        onNextPageRequested: (Int) -> Unit,
        onPmrFilterValueChange: (Boolean) -> Unit,
    ): ScaffoldProperty {
        if (state.firstSanisettesResult == null) {
            return loading(eventActionHandler)
        }
        val topAppBarProperty = topAppBarPropertyMapper.mapPmrFilterTopAppBar(
            pmrFilterEnable = state.pmrFilterEnable,
            onPmrFilterValueChange = onPmrFilterValueChange
        )
        return state.firstSanisettesResult.fold(
            onSuccess = {
                scaffold(
                    topAppBarProperty = topAppBarProperty,
                    eventActionHandler = eventActionHandler,
                    contentProperty = LazyColumnContentProperty(
                        items = mapScreen(
                            state = state,
                            eventActionHandler = eventActionHandler,
                            onNextPageRequested = onNextPageRequested
                        )
                    )
                )
            },
            onFailure = {
                loggerProvider.e(TAG, "Error while loading sanisettes", it)
                scaffold(
                    topAppBarProperty = topAppBarProperty,
                    eventActionHandler = eventActionHandler,
                    contentProperty = ErrorContentProperty(
                        property = errorPropertyMapper.mapUnknownError()
                    )
                )
            }
        )
    }

    private fun mapScreen(
        state: SanisetteListState,
        onNextPageRequested: (Int) -> Unit,
        eventActionHandler: EventActionHandler,
    ): List<Property> = mutableListOf<Property>().apply {
        addAll(
            mapSanisettes(state, eventActionHandler)
        )
        if (state.nextOffset != null) {
            add(
                LoadingProperty {
                    onNextPageRequested.invoke(state.nextOffset)
                }
            )
        }
    }

    private fun mapSanisettes(
        state: SanisetteListState,
        eventActionHandler: EventActionHandler,
    ): List<Property> {
        val filtered = if (state.pmrFilterEnable) {
            state.sanisettes.filter {
                it.isPmr
            }
        } else {
            state.sanisettes
        }
        return filtered.map {
            sanisetteCardMapper.map(it) {
                eventActionHandler.handle(
                    Action.Navigation(
                        navigationElement = NavigationElement.Details(
                            sanisette = it
                        )
                    )
                )
            }
        }
    }
}
