package eu.ciambella.sanisettes.present.screen.maps

import eu.ciambella.sanisettes.design.components.MarkerProperty
import eu.ciambella.sanisettes.design.core.content.ContentProperty
import eu.ciambella.sanisettes.design.core.content.LazyColumnContentProperty
import eu.ciambella.sanisettes.design.core.content.MapsContentProperty
import eu.ciambella.sanisettes.design.core.scaffold.ScaffoldProperty
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.present.common.mapper.NavigationBarPropertyMapper
import eu.ciambella.sanisettes.present.common.mapper.RouteNavigationBarProperty
import eu.ciambella.sanisettes.present.common.navigation.Action
import eu.ciambella.sanisettes.present.common.navigation.EventActionHandler
import eu.ciambella.sanisettes.present.common.navigation.NavigationElement

class SanisetteMapsScreenMapper(
    private val navigationBarPropertyMapper: NavigationBarPropertyMapper,
) {

    private fun scaffold(
        contentProperty: ContentProperty,
        eventActionHandler: EventActionHandler,
    ) = ScaffoldProperty(
        contentProperty = contentProperty,
        navigationBarProperty = navigationBarPropertyMapper.main(
            selectedRoute = RouteNavigationBarProperty.MAPS,
            eventActionHandler = eventActionHandler,
        ),
    )

    fun loading(
        eventActionHandler: EventActionHandler
    ): ScaffoldProperty = scaffold(
        eventActionHandler = eventActionHandler,
        contentProperty = LazyColumnContentProperty(
            items = mutableListOf()
        )
    )

    fun map(
        state: SanisetteMapsState,
        eventActionHandler: EventActionHandler,
    ): ScaffoldProperty {
        if (state.sanisettes == null) {
            return loading(eventActionHandler)
        }
        return state.sanisettes.fold(
            onSuccess = {
                mapSuccess(it, eventActionHandler)
            },
            onFailure = {
                TODO()
            }
        )
    }

    private fun mapSuccess(
        sanisettes: List<Sanisette>,
        eventActionHandler: EventActionHandler,
    ) = scaffold(
        eventActionHandler = eventActionHandler,
        contentProperty = MapsContentProperty(
            markers = sanisettes.map {
                MarkerProperty(
                    latitude = it.location.latitude,
                    longitude = it.location.longitude,
                    title = it.address,
                    onClick = {
                        eventActionHandler.handle(
                            Action.Navigation(
                                navigationElement = NavigationElement.SanisetteNavigation(
                                    address = it.address
                                )
                            )
                        )
                    }
                )
            }
        )
    )
}
