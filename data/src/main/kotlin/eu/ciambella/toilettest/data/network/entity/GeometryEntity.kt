package eu.ciambella.toilettest.data.network.entity

import kotlinx.serialization.Serializable

@Serializable
data class GeometryEntity(
    val type: String,
    val coordinates: List<Double>
)
