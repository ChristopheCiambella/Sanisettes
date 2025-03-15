package eu.ciambella.sanisettes.present.screen.list

import eu.ciambella.sanisettes.design.components.ErrorProperty
import eu.ciambella.sanisettes.design.components.Property
import eu.ciambella.sanisettes.design.components.SanisetteCardShimmerProperty
import eu.ciambella.sanisettes.design.core.content.ContentProperty
import eu.ciambella.sanisettes.design.core.content.ErrorContentProperty
import eu.ciambella.sanisettes.design.core.content.LazyColumnContentProperty
import eu.ciambella.sanisettes.design.core.scaffold.ScaffoldProperty
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.present.common.mapper.NavigationBarPropertyMapper
import eu.ciambella.sanisettes.present.common.mapper.RouteNavigationBarProperty
import eu.ciambella.sanisettes.present.common.mapper.SanisetteCardMapper
import eu.ciambella.sanisettes.present.common.navigation.Action
import eu.ciambella.sanisettes.present.common.navigation.EventActionHandler
import eu.ciambella.sanisettes.present.common.navigation.NavigationElement

class SanisetteListScreenMapper(
    private val navigationBarPropertyMapper: NavigationBarPropertyMapper,
    private val sanisetteCardMapper: SanisetteCardMapper,
) {

    private fun scaffold(
        contentProperty: ContentProperty,
        eventActionHandler: EventActionHandler,
    ) = ScaffoldProperty(
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
    ): ScaffoldProperty {
        if (state.sanisettes == null) {
            return loading(eventActionHandler)
        }
        return state.sanisettes.fold(
            onSuccess = { toilets ->
                scaffold(
                    eventActionHandler = eventActionHandler,
                    contentProperty = LazyColumnContentProperty(
                        items = mapScreen(toilets, eventActionHandler)
                    )
                )
            },
            onFailure = {
                scaffold(
                    eventActionHandler = eventActionHandler,
                    contentProperty = ErrorContentProperty(
                        property = ErrorProperty(
                            title = "Erreur", // TODO
                            message = "Une erreur est survenue", // TODO
                            action = "Réessayer", // TODO
                            onActionClick = {}
                        )
                    )
                )
            }
        )
    }

    private fun mapScreen(
        sanisettes: List<Sanisette>,
        eventActionHandler: EventActionHandler,
    ): List<Property> = mutableListOf<Property>().apply {
        addAll(
            sanisettes.map {
                sanisetteCardMapper.map(it) {
                    eventActionHandler.handle(
                        Action.Navigation(
                            navigationElement = NavigationElement.SanisetteNavigation(
                                address = it.address
                            )
                        )
                    )
                }
            }
        )
    }

}

