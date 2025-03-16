package eu.ciambella.sanisettes.present.screen.maps

import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

data class SanisetteMapsState(
    val firstSanisettesResult: Result<Sanisettes>? = null,
    val searchSanisettesResult: Result<Sanisettes>? = null,
    val sanisettes: List<Sanisette> = emptyList(),
    val sanisetteDetails: Sanisette? = null,
    val searchLocation: Location? = null
)
