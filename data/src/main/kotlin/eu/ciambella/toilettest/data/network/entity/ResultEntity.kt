package eu.ciambella.toilettest.data.network.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultEntity(
    @SerialName("adresse")
    val adresse: String,
    @SerialName("horaire")
    val horaire: String,
    @SerialName("acces_pmr")
    val accesPmr: String,
    @SerialName("geo_point_2d")
    val geoPoint2d: GeometryEntity
)
