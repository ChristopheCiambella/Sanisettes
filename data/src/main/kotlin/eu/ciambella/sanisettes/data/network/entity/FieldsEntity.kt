package eu.ciambella.sanisettes.data.network.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FieldsEntity(
    @SerialName("adresse")
    val adresse: String?,
    @SerialName("horaire")
    val horaire: String?,
    @SerialName("acces_pmr")
    val accesPmr: String?,
    @SerialName("geo_point_2d")
    val geoPoint2d: List<Double>?
)
