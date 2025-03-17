package eu.ciambella.sanisettes.domain.sanisette.model

import eu.ciambella.sanisettes.domain.location.model.Location
import kotlinx.serialization.Serializable

@Serializable
data class Sanisette(
    val address: String,
    val isPmr: Boolean,
    val openingHours: String,
    val distance: String,
    val location: Location
)
