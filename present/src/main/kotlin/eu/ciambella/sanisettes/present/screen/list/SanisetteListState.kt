package eu.ciambella.sanisettes.present.screen.list

import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette

data class SanisetteListState(
    val sanisettes: Result<List<Sanisette>>? = null,
)
