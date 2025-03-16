package eu.ciambella.sanisettes.present.screen.maps

import eu.ciambella.sanisettes.design.atoms.SimpleButtonProperty
import eu.ciambella.sanisettes.design.components.MarkerProperty
import eu.ciambella.sanisettes.design.core.bottomsheet.BottomSheetProperty
import eu.ciambella.sanisettes.design.core.content.ContentProperty
import eu.ciambella.sanisettes.design.core.content.LazyColumnContentProperty
import eu.ciambella.sanisettes.design.core.content.MapsContentProperty
import eu.ciambella.sanisettes.design.core.scaffold.ScaffoldProperty
import eu.ciambella.sanisettes.domain.location.model.Location
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
        onLocationChanged: (Location) -> Unit,
        onBottomSheetDismiss: () -> Unit,
    ): ScaffoldProperty = scaffold(
        bottomSheetContentProperty = mapSanisetteDetails(
            sanisette = state.sanisetteDetails,
            onBottomSheetDismiss = onBottomSheetDismiss,
            eventActionHandler = eventActionHandler,
        ),
        eventActionHandler = eventActionHandler,
        contentProperty = mapMapsContent(
            sanisettes = state.sanisettes,
            centerOnMarkers = state.searchLocation == null,
            onSanisetteClicked = onSanisetteClicked,
            onLocationChanged = onLocationChanged
        )
    )

    private fun mapMapsContent(
        sanisettes: List<Sanisette>?,
        centerOnMarkers: Boolean,
        onSanisetteClicked: (Sanisette) -> Unit,
        onLocationChanged: (Location) -> Unit,
    ) = MapsContentProperty(
        onLocationChanged = { latitude, longitude ->
            onLocationChanged.invoke(Location(latitude, longitude))
        },
        markers = mapSanisettesMarkers(
            sanisettes = sanisettes,
            onSanisetteClicked = onSanisetteClicked
        ),
        centerOnMarkers = centerOnMarkers
    )

    private fun mapSanisettesMarkers(
        sanisettes: List<Sanisette>?,
        onSanisetteClicked: (Sanisette) -> Unit,
    ): List<MarkerProperty> = sanisettes?.map {
        MarkerProperty(
            latitude = it.location.latitude,
            longitude = it.location.longitude,
            title = it.address,
            onClick = {
                onSanisetteClicked.invoke(it)
            }
        )
    } ?: emptyList()

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
