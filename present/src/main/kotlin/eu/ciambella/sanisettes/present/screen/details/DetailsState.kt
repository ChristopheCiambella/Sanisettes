package eu.ciambella.sanisettes.present.screen.details

import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette

data class DetailsState(
    val sanisette: Sanisette? = null,
)
