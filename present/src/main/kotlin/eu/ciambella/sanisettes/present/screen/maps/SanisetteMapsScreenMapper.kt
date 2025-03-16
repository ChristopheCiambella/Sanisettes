package eu.ciambella.sanisettes.present.screen.maps

import eu.ciambella.sanisettes.design.atoms.SimpleButtonProperty
import eu.ciambella.sanisettes.design.components.ErrorProperty
import eu.ciambella.sanisettes.design.components.MarkerProperty
import eu.ciambella.sanisettes.design.core.bottomsheet.BottomSheetProperty
import eu.ciambella.sanisettes.design.core.content.ContentProperty
import eu.ciambella.sanisettes.design.core.content.ErrorContentProperty
import eu.ciambella.sanisettes.design.core.content.LazyColumnContentProperty
import eu.ciambella.sanisettes.design.core.content.MapsContentProperty
import eu.ciambella.sanisettes.design.core.scaffold.ScaffoldProperty
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.present.common.mapper.NavigationBarPropertyMapper
import eu.ciambella.sanisettes.present.common.mapper.RouteNavigationBarProperty
import eu.ciambella.sanisettes.present.common.mapper.SanisetteCardMapper
import eu.ciambella.sanisettes.present.common.navigation.Action
import eu.ciambella.sanisettes.present.common.navigation.EventActionHandler
import eu.ciambella.sanisettes.present.common.navigation.NavigationElement

class SanisetteMapsScreenMapper(
    private val navigationBarPropertyMapper: NavigationBarPropertyMapper,
    private val sanisetteCardMapper: SanisetteCardMapper,
) {

    private fun scaffold(
        contentProperty: ContentProperty,
        bottomSheetContentProperty: BottomSheetProperty? = null,
        eventActionHandler: EventActionHandler,
    ) = ScaffoldProperty(
        bottomSheetContentProperty = bottomSheetContentProperty,
        contentProperty = contentProperty,
        navigationBarProperty = navigationBarPropertyMapper.main(
            selectedRoute = RouteNavigationBarProperty.MAPS,
            eventActionHandler = eventActionHandler,
        ),
    )

    fun loading(
        eventActionHandler: EventActionHandler,
    ): ScaffoldProperty = scaffold(
        eventActionHandler = eventActionHandler,
        contentProperty = LazyColumnContentProperty(
            items = mutableListOf()
        )
    )

    fun map(
        state: SanisetteMapsState,
        eventActionHandler: EventActionHandler,
        onSanisetteClicked: (Sanisette) -> Unit,
        onBottomSheetDismiss: () -> Unit,
    ): ScaffoldProperty {
        if (state.sanisettes == null) {
            return loading(eventActionHandler)
        }
        return state.sanisettes.fold(
            onSuccess = {
                mapSuccess(
                    state = state,
                    sanisettes = it.sanisettes,
                    eventActionHandler = eventActionHandler,
                    onSanisetteClicked = onSanisetteClicked,
                    onBottomSheetDismiss = onBottomSheetDismiss
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

    private fun mapSuccess(
        state: SanisetteMapsState,
        sanisettes: List<Sanisette>,
        eventActionHandler: EventActionHandler,
        onSanisetteClicked: (Sanisette) -> Unit,
        onBottomSheetDismiss: () -> Unit,
    ) = scaffold(
        bottomSheetContentProperty = mapSanisetteDetails(
            sanisette = state.sanisetteDetails,
            onBottomSheetDismiss = onBottomSheetDismiss,
            eventActionHandler = eventActionHandler,
        ),
        eventActionHandler = eventActionHandler,
        contentProperty = MapsContentProperty(
            markers = sanisettes.map {
                MarkerProperty(
                    latitude = it.location.latitude,
                    longitude = it.location.longitude,
                    title = it.address,
                    onClick = {
                        onSanisetteClicked.invoke(it)
                    }
                )
            }
        )
    )

    private fun mapSanisetteDetails(
        sanisette: Sanisette?,
        eventActionHandler: EventActionHandler,
        onBottomSheetDismiss: () -> Unit,
    ): BottomSheetProperty? {
        if (sanisette == null) {
            return null
        }
        val navigate = {
            eventActionHandler.handle(
                Action.Navigation(
                    navigationElement = NavigationElement.SanisetteNavigation(
                        address = sanisette.address
                    )
                )
            )
        }
        return BottomSheetProperty(
            content = LazyColumnContentProperty(
                items = mutableListOf(
                    sanisetteCardMapper.map(sanisette) {
                        navigate.invoke()
                    },
                    SimpleButtonProperty(
                        label = "Démarrer la navigation", // TODO
                        onClick = navigate
                    )
                ),
            ),
            onDismiss = onBottomSheetDismiss
        )
    }
}
