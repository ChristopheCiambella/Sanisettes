package eu.ciambella.sanisettes.domain.location.model

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val latitude: Double,
    val longitude: Double
)
