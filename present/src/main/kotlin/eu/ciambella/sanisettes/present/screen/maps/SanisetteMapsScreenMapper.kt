package eu.ciambella.sanisettes.present.screen.maps

import eu.ciambella.sanisettes.design.atoms.SimpleButtonProperty
import eu.ciambella.sanisettes.design.components.MapsProperty
import eu.ciambella.sanisettes.design.components.MarkerProperty
import eu.ciambella.sanisettes.design.core.bottomsheet.BottomSheetProperty
import eu.ciambella.sanisettes.design.core.content.ContentProperty
import eu.ciambella.sanisettes.design.core.content.LazyColumnContentProperty
import eu.ciambella.sanisettes.design.core.content.MapsContentProperty
import eu.ciambella.sanisettes.design.core.scaffold.ScaffoldProperty
import eu.ciambella.sanisettes.design.core.topbar.TopAppBarProperty
import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.present.R
import eu.ciambella.sanisettes.present.common.mapper.MarkerPropertyMapper
import eu.ciambella.sanisettes.present.common.mapper.NavigationBarPropertyMapper
import eu.ciambella.sanisettes.present.common.mapper.RouteNavigationBarProperty
import eu.ciambella.sanisettes.present.common.mapper.SanisetteCardMapper
import eu.ciambella.sanisettes.present.common.mapper.TopAppBarPropertyMapper
import eu.ciambella.sanisettes.present.common.navigation.Action
import eu.ciambella.sanisettes.present.common.navigation.EventActionHandler
import eu.ciambella.sanisettes.present.common.navigation.NavigationElement

class SanisetteMapsScreenMapper(
    private val topAppBarPropertyMapper: TopAppBarPropertyMapper,
    private val navigationBarPropertyMapper: NavigationBarPropertyMapper,
    private val sanisetteCardMapper: SanisetteCardMapper,
    private val markerPropertyMapper: MarkerPropertyMapper,
) {

    companion object {
        private val PARIS_POSITION = 48.866667 to 2.333333
        private const val PARIS_ZOOM = 11F
    }

    private fun scaffold(
        contentProperty: ContentProperty,
        bottomSheetContentProperty: BottomSheetProperty? = null,
        eventActionHandler: EventActionHandler,
        topAppBarProperty: TopAppBarProperty,
    ) = ScaffoldProperty(
        topAppBarProperty = topAppBarProperty,
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
        topAppBarProperty = topAppBarPropertyMapper.mapSimpleTopAppBar(),
        contentProperty = MapsContentProperty(
            mapsProperty = MapsProperty(
                markers = emptyList(),
                centerOnPosition = PARIS_POSITION,
                centerZoom = PARIS_ZOOM,
                onLocationChanged = { _, _ -> }
            ),
            sheetProperty = null
        )
    )

    fun map(
        state: SanisetteMapsState,
        eventActionHandler: EventActionHandler,
        onSanisetteClicked: (Sanisette) -> Unit,
        onLocationChanged: (Location) -> Unit,
        onBottomSheetDismiss: () -> Unit,
        onPmrFilterValueChange: (Boolean) -> Unit,
    ): ScaffoldProperty = scaffold(
        topAppBarProperty = topAppBarPropertyMapper.mapPmrFilterTopAppBar(
            pmrFilterEnable = state.pmrFilterEnable,
            onPmrFilterValueChange = onPmrFilterValueChange
        ),
        bottomSheetContentProperty = mapSanisetteDetails(
            sanisette = state.sanisetteDetails,
            onBottomSheetDismiss = onBottomSheetDismiss,
            eventActionHandler = eventActionHandler,
        ),
        eventActionHandler = eventActionHandler,
        contentProperty = mapMapsContent(
            state = state,
            onSanisetteClicked = onSanisetteClicked,
            onLocationChanged = onLocationChanged
        )
    )

    private fun mapMapsContent(
        state: SanisetteMapsState,
        onSanisetteClicked: (Sanisette) -> Unit,
        onLocationChanged: (Location) -> Unit,
    ) = MapsContentProperty(
        mapsProperty = MapsProperty(
            markers = mapSanisettesMarkers(
                onlyPmrFilter = state.pmrFilterEnable,
                sanisettes = state.sanisettes,
                onSanisetteClicked = onSanisetteClicked
            ),
            centerOnPosition = PARIS_POSITION,
            centerZoom = PARIS_ZOOM,
            onLocationChanged = { latitude, longitude ->
                onLocationChanged.invoke(Location(latitude, longitude))
            }
        ),
        sheetProperty = null
    )

    private fun mapSanisettesMarkers(
        onlyPmrFilter: Boolean,
        sanisettes: List<Sanisette>?,
        onSanisetteClicked: (Sanisette) -> Unit,
    ): List<MarkerProperty> {
        val filtered = if (onlyPmrFilter) {
            sanisettes?.filter {
                it.isPmr
            }
        } else {
            sanisettes
        } ?: emptyList()
        return filtered.map {
            markerPropertyMapper.map(it) {
                onSanisetteClicked.invoke(it)
            }
        }
    }

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
                    navigationElement = NavigationElement.Navigation(
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
                        labelResId = R.string.start_navigation,
                        onClick = navigate
                    )
                ),
            ),
            onDismiss = onBottomSheetDismiss
        )
    }
}
