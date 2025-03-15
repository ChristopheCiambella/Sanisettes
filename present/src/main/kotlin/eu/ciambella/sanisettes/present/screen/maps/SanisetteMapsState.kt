package eu.ciambella.sanisettes.present.screen.maps

import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette

data class SanisetteMapsState(
    val sanisettes: Result<List<Sanisette>>? = null,
    val sanisetteDetails: Sanisette? = null
)
