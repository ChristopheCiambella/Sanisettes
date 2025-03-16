package eu.ciambella.sanisettes.present.screen.maps

import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

data class SanisetteMapsState(
    val sanisettes: Result<Sanisettes>? = null,
    val sanisetteDetails: Sanisette? = null
)
