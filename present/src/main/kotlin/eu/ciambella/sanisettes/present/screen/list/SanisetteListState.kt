package eu.ciambella.sanisettes.present.screen.list

import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

data class SanisetteListState(
    val firstSanisettesResult: Result<Sanisettes>? = null,
    val nextSanisettesResult: Result<Sanisettes>? = null,
    val sanisettes: List<Sanisette> = emptyList(),
    val nextOffset: Int? = null,
)
