package eu.ciambella.toilettest.domain.toilet.model

data class Toilet(
    val address: String,
    val isPmr: Boolean,
    val openingHours: String,
    val longitude: Double,
    val latitude: Double
)
