package eu.ciambella.toilettest.domain.toilet.model

import eu.ciambella.toilettest.domain.location.model.Location

data class Sanisette(
    val address: String,
    val isPmr: Boolean,
    val isBaby: Boolean,
    val openingHours: String,
    val distance: String,
    val location: Location
)
