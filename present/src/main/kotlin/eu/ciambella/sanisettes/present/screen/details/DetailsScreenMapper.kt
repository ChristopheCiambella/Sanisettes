package eu.ciambella.sanisettes.present.screen.details

import eu.ciambella.sanisettes.design.atoms.SimpleButtonProperty
import eu.ciambella.sanisettes.design.components.MapsProperty
import eu.ciambella.sanisettes.design.components.SanisetteSheetProperty
import eu.ciambella.sanisettes.design.core.content.ContentProperty
import eu.ciambella.sanisettes.design.core.content.ErrorContentProperty
import eu.ciambella.sanisettes.design.core.content.LazyColumnContentProperty
import eu.ciambella.sanisettes.design.core.content.MapsContentProperty
import eu.ciambella.sanisettes.design.core.scaffold.ScaffoldProperty
import eu.ciambella.sanisettes.design.core.topbar.TopAppBarProperty
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.present.R
import eu.ciambella.sanisettes.present.common.mapper.ErrorPropertyMapper
import eu.ciambella.sanisettes.present.common.mapper.MarkerPropertyMapper
import eu.ciambella.sanisettes.present.common.mapper.SanisetteCardMapper
import eu.ciambella.sanisettes.present.common.navigation.Action
import eu.ciambella.sanisettes.present.common.navigation.EventActionHandler
import eu.ciambella.sanisettes.present.common.navigation.NavigationElement

class DetailsScreenMapper(
    private val markerPropertyMapper: MarkerPropertyMapper,
    private val sanisetteCardMapper: SanisetteCardMapper,
    private val errorPropertyMapper: ErrorPropertyMapper,
) {

    companion object {
        private const val MARKER_ZOOM = 17F
    }

    private fun scaffold(
        contentProperty: ContentProperty,
        eventActionHandler: EventActionHandler,
    ) = ScaffoldProperty(
        topAppBarProperty = TopAppBarProperty.SimpleAppBar(
            title = "",
            onBackClicked = {
                eventActionHandler.handle(Action.Navigation(NavigationElement.Up))
            }
        ),
        contentProperty = contentProperty,
    )

    fun loading(
        eventActionHandler: EventActionHandler,
    ): ScaffoldProperty = scaffold(
        eventActionHandler = eventActionHandler,
        contentProperty = LazyColumnContentProperty(
            scrollEnabled = false,
            items = mutableListOf()
        )
    )

    fun map(
        state: DetailsState,
        eventActionHandler: EventActionHandler,
    ): ScaffoldProperty {
        if (state.sanisette == null) {
            return scaffold(
                eventActionHandler = eventActionHandler,
                contentProperty = ErrorContentProperty(
                    property = errorPropertyMapper.mapUnknownError()
                )
            )
        }
        return scaffold(
            eventActionHandler = eventActionHandler,
            contentProperty = MapsContentProperty(
                mapsProperty = mapMapsContent(state.sanisette),
                sheetProperty = SanisetteSheetProperty(
                    sanisetteProperty = sanisetteCardMapper.map(state.sanisette) {},
                    simpleButtonProperty = mapNavigationButton(
                        state.sanisette,
                        eventActionHandler
                    )
                ),
            )
        )
    }

    private fun mapMapsContent(
        sanisette: Sanisette,
    ) = MapsProperty(
        markers = listOf(
            markerPropertyMapper.map(sanisette) {}
        ),
        centerOnPosition = sanisette.location.latitude to sanisette.location.longitude,
        centerZoom = MARKER_ZOOM,
        onLocationChanged = { _, _ -> }
    )

    private fun mapNavigationButton(
        sanisette: Sanisette,
        eventActionHandler: EventActionHandler,
    ) = SimpleButtonProperty(
        labelResId = R.string.start_navigation
    ) {
        eventActionHandler.handle(
            Action.Navigation(
                NavigationElement.Navigation(
                    sanisette.address
                )
            )
        )
    }

}
