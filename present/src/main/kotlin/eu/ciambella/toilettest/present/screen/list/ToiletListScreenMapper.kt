package eu.ciambella.toilettest.present.screen.list

import eu.ciambella.design.toilettest.components.Property
import eu.ciambella.design.toilettest.components.SanisetteCardShimmerProperty
import eu.ciambella.design.toilettest.content.ContentProperty
import eu.ciambella.design.toilettest.content.LazyColumnContentProperty
import eu.ciambella.design.toilettest.scaffold.ScaffoldProperty
import eu.ciambella.toilettest.domain.toilet.model.Sanisette
import eu.ciambella.toilettest.present.common.mapper.NavigationBarPropertyMapper
import eu.ciambella.toilettest.present.common.mapper.RouteNavigationBarProperty
import eu.ciambella.toilettest.present.common.mapper.SanisetteCardMapper
import eu.ciambella.toilettest.present.common.navigation.Action
import eu.ciambella.toilettest.present.common.navigation.EventActionHandler
import eu.ciambella.toilettest.present.common.navigation.NavigationElement

class ToiletListScreenMapper(
    private val navigationBarPropertyMapper: NavigationBarPropertyMapper,
    private val toiletCardMapper: SanisetteCardMapper,
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
        state: ToiletListState,
        eventActionHandler: EventActionHandler,
    ): ScaffoldProperty {
        if (state.toilets == null) {
            return loading(eventActionHandler)
        }
        return state.toilets.fold(
            onSuccess = {
                mapSuccess(it, eventActionHandler)
            },
            onFailure = {
                TODO()
            }
        )
    }

    private fun mapSuccess(
        toilets: List<Sanisette>,
        eventActionHandler: EventActionHandler,
    ) = scaffold(
        eventActionHandler = eventActionHandler,
        contentProperty = LazyColumnContentProperty(
            items = mapScreen(toilets, eventActionHandler)
        )
    )

    private fun mapScreen(
        toilets: List<Sanisette>,
        eventActionHandler: EventActionHandler,
    ): List<Property> = mutableListOf<Property>().apply {
        addAll(
            toilets.map {
                toiletCardMapper.map(it) {
                    eventActionHandler.handle(
                        Action.Navigation(
                            navigationElement = NavigationElement.ToiletNavigation(
                                address = it.address
                            )
                        )
                    )
                }
            }
        )
    }

}

