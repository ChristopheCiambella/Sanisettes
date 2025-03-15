package eu.ciambella.toilettest.data.network.entity

import kotlinx.serialization.Serializable

@Serializable
data class GeometryEntity(
    val lon: Double,
    val lat: Double
)
